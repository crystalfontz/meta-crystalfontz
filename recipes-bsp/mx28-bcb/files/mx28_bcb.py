#!/usr/bin/env python2

#import os
import struct
#import subprocess
#import sys
#import tarfile
#import tempfile

def generate_bootstream_headers(num_bootstream, start_sector):
    return struct.pack("<I"    # Magic
                       "4x"    # Primary Tag (unused)
                       "4x"    # Secondary Tag (unused)
                       "I"     # Number of Boot Stream blocks
                       "8x"    # Padding
                       "4x"    # Primary Tag (unused)
                       "I"     # Base offset of the first bootstream block
                       "4x",   # Padding
                       0x00112233,
                       num_bootstream,
                       start_sector + 1)

def write_bootstream_partition(device_file, start, bootstream):
    with open(device_file, 'r+') as partition:
        partition.seek(start*512)
        partition.write(generate_bootstream_headers(1, start))

        # Fill the rest of the first 512 bytes with 0
        current = partition.tell()
        partition.write(struct.pack("%dx" % (512 - current + (start*512))))

        # Copy the bootstream image
        with open(bootstream, 'r') as image:
            partition.write(image.read())

def main():
    import argparse

    parser = argparse.ArgumentParser(
        description='Flash a SD Card at format expected by iMX28 SoCs')
    parser.add_argument("device", help="Path to the SD Card's device file")
    parser.add_argument("--bootstream", "-b",
                        help="Path to the boostream image", required=True)
    parser.add_argument("--start", "-s",
                        help="Start of the bootlets partion (in sectors)",
                        type=int, required=True)

    args = parser.parse_args()

    write_bootstream_partition(args.device, args.start, args.bootstream)


if __name__ == "__main__":
    main()


