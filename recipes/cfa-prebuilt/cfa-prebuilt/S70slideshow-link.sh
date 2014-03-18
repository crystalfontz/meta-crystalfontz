#!/bin/sh
### BEGIN INIT INFO
# Provides:             cfa-slideshow-link
# Required-Start:
# Required-Stop:
# Default-Start:        S
# Default-Stop:
### END INIT INFO

export USER="root"

read CMDLINE < /proc/device-tree/model
for x in $CMDLINE; do
    case $x in
    CFA-10049)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10055_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
            echo "90" > /etc/rotation
        fi
        exit 0;
        ;;
    CFA-10055)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10055_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
            echo "90" > /etc/rotation
        fi
        exit 0;
        ;;
    CFA-10056)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10056_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
            echo "90" > /etc/rotation
        fi
        exit 0;
        ;;
    CFA-10057)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10057_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
            echo "90" > /etc/rotation
        fi
        exit 0;
        ;;
    CFA-10058)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10058_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
        fi
        exit 0;
        ;;
    esac
done

