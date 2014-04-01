#!/bin/sh
### BEGIN INIT INFO
# Provides:             cfa-preconfig
# Required-Start:
# Required-Stop:
# Default-Start:        S
# Default-Stop:
### END INIT INFO

export USER="root"

read CMDLINE < /proc/device-tree/model
for x in $CMDLINE; do
    case $x in
    CFA-10036)
        echo cfa-preconfig: Booting CFA-10036 | tee /dev/kmsg > /dev/null
        if [ -e /dev/fb0 ]; then
            cat /home/root/CFA10036_splash.bin > /dev/fb0
        fi
        exit 0;
        ;;
    CFA-10037)
        echo cfa-preconfig: Booting CFA-10037 | tee /dev/kmsg > /dev/null
        if [ -e /dev/fb0 ]; then
            cat /home/root/CFA10036_splash.bin > /dev/fb0
        fi
        exit 0;
        ;;
    CFA-10049)
        echo cfa-preconfig: Booting CFA-10049 | tee /dev/kmsg > /dev/null
        if [ -e /dev/fb1 ]; then
            cat /home/root/CFA10036_splash.bin > /dev/fb1
        fi
        exit 0;
        ;;
    CFA-10055)
        echo cfa-preconfig: Booting CFA-10055 | tee /dev/kmsg > /dev/null
        if [ -e /dev/fb1 ]; then
            cat /home/root/CFA10036_splash.bin > /dev/fb1
        fi
        exit 0;
        ;;
    CFA-10056)
        echo cfa-preconfig: Booting CFA-10056 | tee /dev/kmsg > /dev/null
        if [ -e /dev/fb1 ]; then
            cat /home/root/CFA10036_splash.bin > /dev/fb1
        fi
        exit 0;
        ;;
    CFA-10057)
        echo cfa-preconfig: Booting CFA-10057 | tee /dev/kmsg > /dev/null
        if [ -e /dev/fb1 ]; then
            cat /home/root/CFA10036_splash.bin > /dev/fb1
        fi
        exit 0;
        ;;
    CFA-10058)
        echo cfa-preconfig: Booting CFA-10058 | tee /dev/kmsg > /dev/null
        if [ -e /dev/fb1 ]; then
            cat /home/root/CFA10036_splash.bin > /dev/fb1
        fi
        exit 0;
        ;;
    esac
done

