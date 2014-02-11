DESCRIPTION = "Extra files for cfa-matrix-demo"
LICENSE = "GPLv2"
PR = "r1"

S="${WORKDIR}"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c746876a5e2eaefef09efb9d7c1c463d"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INSANE_SKIP_${PN} = "True"
INSANE_SKIP_${PN} += "already-stripped"
INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN} += "debug-files"
 
SRC_URI += "file://doom.sh \
            file://doom1.wad \
            file://prboom.wad \
			file://LICENSE \
"

do_install () {
    install -d ${D}/${bindir}
    install -d ${D}/${datadir}/games
    install -d ${D}/${datadir}/games/doom
    install -d ${D}/usr/games
    install -m 0755 ${WORKDIR}/doom.sh ${D}${bindir}
    install -m 0644 ${WORKDIR}/doom1.wad ${D}/${datadir}/games/doom
    install -m 0644 ${WORKDIR}/prboom.wad ${D}/${datadir}/games/doom
}

FILES_${PN} += "/usr/share/*"
FILES_${PN} += "/usr/games/*/*"
FILES_${PN} += "/usr/games"
