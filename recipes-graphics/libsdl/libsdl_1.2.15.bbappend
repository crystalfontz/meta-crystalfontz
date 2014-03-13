PRINC := "${@int(PRINC) + 2}"
FILESEXTRAPATHS := "${THISDIR}/${PN}"

DESCRIPTION = "Simple DirectMedia Layer (X11, Framebuffer, +some OMAP support)"
LIC_FILES_CHKSUM = "file://COPYING;md5=27818cd7fd83877a8e3ef82b82798ef4"

EXTRA_OECONF += " \
  --enable-static --disable-debug --enable-cdrom --enable-threads --enable-timers --enable-endian \
  --with-fop=no --with-xmlto=no --enable-file --enable-oss --enable-alsa --disable-esd --disable-arts \
  --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
  --disable-mintaudio --disable-nasm --enable-video-x11=yes --disable-video-dga \
  --enable-video-fbcon --enable-video-fbdev --enable-video-directfb --disable-video-ps2gs \
  --disable-video-xbios --disable-video-gem --disable-video-dummy --enable-shared \
  --enable-video-opengl --enable-input-events --enable-pthreads \
  --disable-video-picogui --enable-video-qtopia --enable-dlopen \
  --enable-input-tslib --disable-video-ps3 \
"
