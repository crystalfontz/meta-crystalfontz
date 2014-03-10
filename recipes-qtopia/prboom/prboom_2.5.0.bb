DESCRIPTION = "A Doom Clone based on SDL"
SECTION = "games"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-net libpng"
LICENSE = "GPL"

LIC_FILES_CHKSUM = "file://${FILE_DIRNAME}/files/LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PR = "r5"
#RRECOMMENDS_${PN} = "freedoom"

SRC_URI = "${SOURCEFORGE_MIRROR}/prboom/prboom%20stable/${PV}/prboom-${PV}.tar.gz \
	   file://gnu_source_for_sched_h.patch \
	   file://prboom-2.5.0-libpng-1.4.patch \
	   "

inherit autotools

EXTRA_OECONF += " --disable-gl --disable-cpu-opt --without-x --disable-sdltest \
                 SDL_CONFIG=${STAGING_BINDIR_CROSS}/sdl-config --oldincludedir=${STAGING_LIBDIR} \
				 --with-sdl-prefix=	${STAGING_DIR}/${HOST_SYS}/usr \
				 --with-sdl-exec-prefix=	${STAGING_DIR}/${HOST_SYS}/usr \
                 "

do_install() {
        install -d ${D}${bindir} 

	install -m 0755 src/prboom ${D}${bindir}/prboom
}
#	install -m 0644 data/prboom.wad ${D}${datadir}/games/doom/
#		   ${D}${datadir}/games/doom

#FILES_${PN} += "${datadir}/games/doom/prboom.wad"

SRC_URI[md5sum] = "a8a15f61fa2626ab98051ab2703378c4"
SRC_URI[sha256sum] = "226c1c470f8cc983327536404f405a1d026cf0a5188c694a1243cc8630014bae"
