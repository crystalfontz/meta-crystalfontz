DESCRIPTION = "Extra files for cfa-matrix-demo"
LICENSE = "GPLv2"
PR = "r0"

S="${WORKDIR}"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c746876a5e2eaefef09efb9d7c1c463d"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INSANE_SKIP_${PN} = "True"
INSANE_SKIP_${PN} += "already-stripped"
INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN} += "debug-files"

INSANE_SKIP_${PN}-dev += "ldflags"
 
SRC_URI += "file://doom.sh \
            file://prboom \
            file://prboom-game-server \
            file://doom1.wad \
            file://prboom.wad \
			file://lib/libpng14.so \
			file://lib/libpng14.so.14 \
			file://lib/libpng14.so.14.12.0 \
			file://lib/lcdproc \
			file://LICENSE \
"

do_install () {
    install -d ${D}/${libdir}/lcdproc
    install -d ${D}/${bindir}
    install -d ${D}/${datadir}/games
    install -d ${D}/${datadir}/games/doom
    install -d ${D}/usr/games
    install -m 0755 ${WORKDIR}/doom.sh ${D}${bindir}
    install -m 0755 ${WORKDIR}/prboom ${D}/usr/games
    install -m 0755 ${WORKDIR}/prboom-game-server ${D}/usr/games
    install -m 0644 ${WORKDIR}/doom1.wad ${D}/${datadir}/games/doom
    install -m 0644 ${WORKDIR}/prboom.wad ${D}/${datadir}/games/doom
    cp -R ${WORKDIR}/lib/*.so ${D}/${libdir}
}

FILES_${PN} += "/usr/lib"
FILES_${PN} += "/usr/lib/lcdproc/*"
FILES_${PN} += "/usr/share/*"
FILES_${PN} += "/usr/games/*/*"
FILES_${PN} += "/usr/games"

#			file://lib/libSDL-1.2.so.0 
#			file://lib/libSDL-1.2.so.0.11.4 
#			file://lib/libSDL_mixer-1.2.so.0 
#			file://lib/libSDL_mixer-1.2.so.0.12.0 
#			file://lib/libSDL_mixer.so 
#			file://lib/libSDL.so
#			file://lib/libSDL_net-1.2.so.0 
#			file://lib/libSDL_net-1.2.so.0.8.0 
#			file://lib/libSDL_net.so 
