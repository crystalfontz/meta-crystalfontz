#!/bin/sh
### BEGIN INIT INFO
# Provides:             cfa-preconfig
# Required-Start:
# Required-Stop:
# Default-Start:        S
# Default-Stop:
### END INIT INFO

read CMDLINE < /proc/device-tree/compatible
for x in $CMDLINE; do
        case $x in
        CFA-10036)
                echo "Booting CFA-10036"
				if [ -e /dev/fb0 ]; then
						cat /home/root/CFA10036_splash.bin > /dev/fb0
				fi
                exit 0;
                ;;
        CFA-10037)
                echo "Booting CFA-10037"
				if [ -e /dev/fb0 ]; then
						cat /home/root/CFA10036_splash.bin > /dev/fb0
				fi
                exit 0;
                ;;
        CFA-10049)
                echo "Booting CFA-10049"
				if [ -e /dev/fb1 ]; then
						cat /home/root/CFA10036_splash.bin > /dev/fb1
				fi
                exit 0;
                ;;
        CFA-10055)
                echo "Booting CFA-10055"
				if [ -e /dev/fb1 ]; then
						cat /home/root/CFA10036_splash.bin > /dev/fb1
						echo "90" > /etc/rotation
				fi
                exit 0;
                ;;
        CFA-10056)
                echo "Booting CFA-10056"
				if [ -e /dev/fb1 ]; then
						cat /home/root/CFA10036_splash.bin > /dev/fb1
						echo "90" > /etc/rotation
				fi
                exit 0;
                ;;
        CFA-10057)
                echo "Booting CFA-10057"
				if [ -e /dev/fb1 ]; then
						cat /home/root/CFA10036_splash.bin > /dev/fb1
						echo "90" > /etc/rotation
				fi
                exit 0;
                ;;
        CFA-10058)
                echo "Booting CFA-10058"
				if [ -e /dev/fb1 ]; then
						cat /home/root/CFA10036_splash.bin > /dev/fb1
				fi
                exit 0;
                ;;
        esac
done

