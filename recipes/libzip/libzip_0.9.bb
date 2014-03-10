DESCRIPTION = "C library for reading, creating, and modifying zip archives"
SECTION = "libs"
HOMEPAGE = "http://www.nih.at/libzip"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${FILE_DIRNAME}/files/BSD;md5=3775480a712fc46a69647678acb234cb"

DEPENDS = "zlib"
PR = "r1"

SRC_URI = "http://www.nih.at/${PN}/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

SRC_URI[md5sum] = "56b9f11c1eee5eed189a20183d7e06b0"
SRC_URI[sha256sum] = "23a8c3624122a3777bb4ac3be4a867fd0bed7f3aacb8f1d0b68fc459cfb035fc"
