DESCRIPTION = "Simple DirectMedia Layer networking library."
SECTION = "libs/network"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://COPYING;md5=9cf3de2d872bf510f88eb20d06d700b5"

SRC_URI = " \
  http://www.libsdl.org/projects/SDL_net/release/SDL_net-${PV}.tar.gz \
  file://libtool2.patch \
"

S = "${WORKDIR}/SDL_net-${PV}"

inherit autotools
#inherit autotools lib_package binconfig pkgconfig

EXTRA_OECONF += "SDL_CONFIG=${STAGING_BINDIR_CROSS}/sdl-config"

SRC_URI[md5sum] = "20e64e61d65662db66c379034f11f718"
SRC_URI[sha256sum] = "5f4a7a8bb884f793c278ac3f3713be41980c5eedccecff0260411347714facb4"

do_configure () {
    # Remove old libtool macros.
    MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
    for i in ${MACROS}; do
        rm -f acinclude/$i
    done
    cp build-scripts/* . || true
    rm -rf build-scripts/
    export SYSROOT=$PKG_CONFIG_SYSROOT_DIR

    autotools_do_configure

    rm config.log
    for i in $(find -name "Makefile") ; do
        sed -i -e 's:-L/usr/lib:-L${STAGING_LIBDIR}:g' $i
    done
}
