#!/bin/sh

export SDL_VIDEODRIVER=directfb
/usr/bin/nice -n -20 /usr/bin/prboom -width 800 -height 480
