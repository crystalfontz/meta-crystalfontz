DESCRIPTION = "QT File Manager"
LICENSE = "GPLv2+"
HOMEPAGE = "http://www.qtfm.org"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
SECTION = "qt/app"

PR = "pr1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit qt4e pkgconfig

RDEPENDS_${PN} += "libgles2"

SRC_URI = "http://www.qtfm.org/qtfm-${PV}.tar.gz"

SRC_URI[md5sum] = "cc1d930503bf0dedc824d6f2abdda719"
SRC_URI[sha256sum] = "845fc43800d12483fa1993c56a8c965ff8dc917b97f03d9ce2e24318806fb211"

#S = "${WORKDIR}/${PN}"

FILES_${PN} = " \
    ${bindir}/${PN} \
    ${datadir}/applications/${PN}.desktop \
    ${datadir}/pixmaps \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0744 ${PN} ${D}${bindir}

    sed -i -e '/Exec.*/d' qtfm.desktop
    sed -i -e '/Icon.*/d' qtfm.desktop

    echo 'Exec=${bindir}/${PN}' >> qtfm.desktop
    echo 'Icon=${PN}' >> qtfm.desktop

    install -d ${D}${datadir}/applications
    install -m 0644 ${PN}.desktop ${D}${datadir}/applications

    install -d ${D}${datadir}/pixmaps
    install -m 0644 images/*.png ${D}${datadir}/pixmaps
}
