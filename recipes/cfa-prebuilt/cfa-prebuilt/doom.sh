#!/bin/sh

export SDL_VIDEODRIVER=directfb
#set DOOM_CMDLINE = "/usr/bin/nice -n -20 /usr/bin/prboom -width 800 -height 480"

read CMDLINE < /proc/device-tree/model
for x in $CMDLINE; do
    case $x in
    CFA-10049)
		/usr/bin/nice -n -20 /usr/bin/prboom -width 320 -height 480
        ;;
    CFA-10055)
		/bin/nice -n -20 /usr/bin/prboom -width 320 -height 480
        ;;
    CFA-10056)
		/bin/nice -n -20 /usr/bin/prboom -width 480 -height 800
        ;;
    CFA-10057)
		/usr/bin/nice -n -20 /usr/bin/prboom -width 480 -height 800
        ;;
    CFA-10058)
		/usr/bin/nice -n -20 /usr/bin/prboom -width 800 -height 480
        ;;
    esac
done

