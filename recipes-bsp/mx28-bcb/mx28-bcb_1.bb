# Copyright (C) 2013 Free Electrons
# Released under the GPLv2 license

DESCRIPTION = "Utility to generate the Boot Control Block for freescale mx28 platforms"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

SECTION = "bootloader"
PR = "r1"
BBCLASSEXTEND = "native nativesdk"

SRC_URI = "file://mx28_bcb.py\
           file://COPYING"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install ${WORKDIR}/mx28_bcb.py ${D}${bindir}
}
