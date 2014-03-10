DESCRIPTION = "SDL graphics drawing primitives and other support functions."
SECTION = "libs"

LICENSE = "zlib"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d1de21f0b70830e299905eac3419084"

PR = "r2"

DEPENDS = "zlib libpng jpeg virtual/libsdl"

SRC_URI = "http://www.ferzkopp.net/Software/SDL_gfx-2.0/SDL_gfx-${PV}.tar.gz \
"

EXTRA_OECONF += "SDL_CONFIG=${STAGING_BINDIR_CROSS}/sdl-config --disable-mmx"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI[md5sum] = "838514185ff9a3b6377760aaa52fef8a"
SRC_URI[sha256sum] = "30ad38c3e17586e5212ce4a43955adf26463e69a24bb241f152493da28d59118"

S = "${WORKDIR}/SDL_gfx-${PV}"

#inherit autotools
inherit autotools lib_package binconfig pkgconfig

