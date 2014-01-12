require recipes-bsp/barebox/barebox.inc

SRC_URI = "http://barebox.org/download/${PN}-2013.08.0.tar.bz2 \
           file://defconfig"

SRC_URI[md5sum] = "a61b97a2fedebc808d4b182c2ca18a0c"
SRC_URI[sha256sum] = "d9e46dd3c68b04ab4cbc37135dc34907dbebef393da4b3e54abb203c295c1620"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

S = "${WORKDIR}/${PN}-2013.08.0"

COMPATIBLE_MACHINE_cfa10036 = "cfa10036"
