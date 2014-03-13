DESCRIPTION = "Extra files for cfa-matrix-demo"
LICENSE = "GPLv2"
PR = "r1"

S="${WORKDIR}"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c746876a5e2eaefef09efb9d7c1c463d"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit pkgconfig

INSANE_SKIP_${PN} = "True"
INSANE_SKIP_${PN} += "already-stripped"
INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN} += "debug-files"
 
SRC_URI += "file://doom.sh \
            file://doom1.wad \
            file://prboom-game-server \
            file://prboom.wad \
			file://LICENSE \
			file://reboot_icon.png \
			file://reboot.desktop \
			file://doom.desktop \
			file://doom.png \
			"

do_install () {
    install -d ${D}/${bindir}
    install -d ${D}/${datadir}/games
    install -d ${D}/${datadir}/games/doom
    install -d ${D}/${datadir}/pixmaps
    install -d ${D}/${datadir}/applications
    install -d ${D}/${prefix}/games
    install -m 0755 ${WORKDIR}/doom.sh ${D}${bindir}
    install -m 0644 ${WORKDIR}/prboom-game-server ${D}/usr/games
    install -m 0644 ${WORKDIR}/doom1.wad ${D}/${datadir}/games/doom
    install -m 0644 ${WORKDIR}/prboom.wad ${D}/${datadir}/games/doom
    install -m 0644 ${WORKDIR}/doom.desktop ${D}/${datadir}/applications/
    install -m 0644 ${WORKDIR}/reboot.desktop ${D}/${datadir}/applications/
    install -m 0644 ${WORKDIR}/doom.png ${D}/${datadir}/pixmaps/
    install -m 0644 ${WORKDIR}/reboot_icon.png ${D}/${datadir}/pixmaps/
}

FILES_${PN} += "/usr/share/*"
FILES_${PN} += "/usr/games/*/*"
FILES_${PN} += "/usr/games"
