DESCRIPTION = "Extra files for demo-image-cfa"
LICENSE = "GPLv2"
PR = "r1"
S="${WORKDIR}"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c746876a5e2eaefef09efb9d7c1c463d"

SRC_URI += "file://qtbrowser.desktop \
            file://webkit.png \
            file://qtmediaplayer.desktop \
            file://qtmediaplayer.png \
            file://qtdemo.desktop \
            file://qtdemo.png \
            file://LICENSE"

inherit allarch

do_install () {
    install -d ${D}/${datadir}/pixmaps
    install -d ${D}/${datadir}/applications
    install -m 0644 ${WORKDIR}/webkit.png ${D}/${datadir}/pixmaps
    install -m 0644 ${WORKDIR}/qtbrowser.desktop ${D}/${datadir}/applications
    install -m 0644 ${WORKDIR}/qtmediaplayer.png ${D}/${datadir}/pixmaps
    install -m 0644 ${WORKDIR}/qtmediaplayer.desktop ${D}/${datadir}/applications
    install -m 0644 ${WORKDIR}/qtdemo.png ${D}/${datadir}/pixmaps
    install -m 0644 ${WORKDIR}/qtdemo.desktop ${D}/${datadir}/applications
}
