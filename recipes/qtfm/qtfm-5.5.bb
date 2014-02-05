DESCRIPTION = "QT File Manager"
LICENSE = "GPLv2+"
HOMEPAGE = "http://www.qtfm.org"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
SECTION = "qt/app"

PR = "pr0"

SRC_URI = "http://www.qtfm.org/qtfm-${PV}.tar.gz"

SRC_URI[md5sum] = "00441b53cf14c03566c8e82643544ff9"
SRC_URI[sha256sum] = "6fa90016530b3aa6102e254079461977439398531fb23e7ec076ff2c140fea0a"

S = "${WORKDIR}/${PN}"

FILES_${PN} = " \
    ${bindir}/${PN} \
    ${datadir}/applications/${PN}.desktop \
    ${datadir}/pixmaps/${PN}.png \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0744 ${S}/${PN} ${D}${bindir}

    sed -i -e '/Exec.*/d' qtfm.desktop
    sed -i -e '/Icon.*/d' qtfm.desktop

    echo 'Exec=${bindir}/${PN}' >> qtfm.desktop
    echo 'Icon=${PN}' >> qtfm.desktop

    install -d ${D}${datadir}/applications
    install -m 0644 ${S}/${PN}.desktop ${D}${datadir}/applications

    install -d ${D}${datadir}/pixmaps
    install -m 0644 ${S}/${PN}.png ${D}${datadir}/pixmaps
}
