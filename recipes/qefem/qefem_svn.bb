HOMEPAGE = "http://code.google.com/p/qefem/"
#SECTION = "network"
DESCRIPTION = "Qt based filemanager with two panels."
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://${FILE_DIRNAME}/files/LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"


FILESEXTRAPATHS_prepend := "${THISDIR}/files/${PN}:"

SRCREV = "ed286384939c8b86d86547b2e009827c0d9f93e3"

SRC_URI = "svn://qefem.googlecode.com/svn/;module=trunk;rev=HEAD;protocol=https \
		  file://${FILE_DIRNAME}/files/LICENSE \
		  file://patch_to_build_regardless.diff \
"		   

S = "${WORKDIR}/trunk/"

inherit qt4e
ARM_INSTRUCTION_SET = "arm"

do_install () {
       install -d ${D}${bindir}
       install -m 755 qefem ${D}/${bindir}/qefem
}



#FILES_${PN} += "${datadir}/qefem/"
