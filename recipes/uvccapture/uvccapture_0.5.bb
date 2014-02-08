# uvccapture_0.5.bb  2009-03-06 RudolfReuter
DESCRIPTION = "USB UVC Video Class Snapshot Software for V4L2 driver."
SECTION = "console/multimedia"
PRIORITY = "optional"
DEPENDS = "jpeg"
LICENSE = "GPLv2"
PR = "r0"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

inherit pkgconfig

#S = "${WORKDIR}/${PN}"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/u/uvccapture/uvccapture_0.5.orig.tar.gz \
           file://Makefile.patch;patch=1 \
           file://uvccapture-videodev2-header.patch;patch=1 \
           "

SRC_URI[md5sum] = "c46dfabef857c9796d5be55434a9b99a"
SRC_URI[sha256sum] = "f162692226c073000a12093b0c9e70f8230e44ec284f35925b798d5cd99c6aac"

do_compile() {
   make
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 uvccapture ${D}${bindir}/uvccapture
}
