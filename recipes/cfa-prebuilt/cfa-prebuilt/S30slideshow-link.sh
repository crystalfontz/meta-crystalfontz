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
        fi
        echo "270" > /etc/rotation
        if [ -e /home/root/.configuration/xorg.conf_cfa10049 ]; then
        cp /home/root/.configuration/xorg.conf_cfa10049 /etc/X11/xorg.conf
        cp /home/root/.configuration/01xrandr /etc/X11/Xinit.d/01xrandr
		fi
        if [ -e /home/root/.configuration/pointercal.xinput ]; then
			mv /home/root/.configuration/pointercal.xinput /etc/pointercal.xinput
		fi
        exit 0;
        ;;
    CFA-10055)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10055_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
        fi
        echo "270" > /etc/rotation
        if [ -e /home/root/.configuration/xorg.conf_cfa10055 ]; then
        cp /home/root/.configuration/xorg.conf_cfa10055 /etc/X11/xorg.conf
        cp /home/root/.configuration/01xrandr /etc/X11/Xinit.d/01xrandr
        mv /home/root/.configuration/pointercal.xinput /etc/pointercal.xinput
		fi
        if [ -e /home/root/.configuration/pointercal.xinput ]; then
			mv /home/root/.configuration/pointercal.xinput /etc/pointercal.xinput
		fi
        exit 0;
        ;;
    CFA-10056)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10056_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
        fi
        echo "270" > /etc/rotation
        if [ -e /home/root/.configuration/xorg.conf_cfa10056 ]; then
        cp /home/root/.configuration/xorg.conf_cfa10056 /etc/X11/xorg.conf
        fi
        exit 0;
        ;;
    CFA-10057)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10057_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
        fi
        echo "90" > /etc/rotation
        if [ -e /home/root/.configuration/xorg.conf_cfa10057 ]; then
        cp /home/root/.configuration/xorg.conf_cfa10057 /etc/X11/xorg.conf
		fi
        exit 0;
        ;;
    CFA-10058)
        if [ ! -L /home/root/images/slideshow.sh ]; then
            busybox ln -s /home/root/images/CFA10058_slideshow /home/root/images/slideshow.sh
            echo creating slideshow symlink | tee /dev/kmsg > /dev/null
        fi
        if [ -e /home/root/.configuration/xorg.conf_cfa10058 ]; then
        cp /home/root/.configuration/xorg.conf_cfa10058 /etc/X11/xorg.conf
		fi
        exit 0;
        ;;
    esac
done

