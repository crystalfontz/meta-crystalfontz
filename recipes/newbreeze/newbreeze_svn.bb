HOMEPAGE = "http://sourceforge.net/projects/newbreeze/"
#SECTION = "network"
DESCRIPTION = "Fast and light-weight File Manager."
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file:///${WORKDIR}/NewBreeze/debian/copyright;md5=edbe551f06368ca911b2b5e0797fb31e"

DEPENDS = "libtar libzip zlib bzip2 lzma"
RDEPENDS_${PN} = "zlib"

SRC_URI = "http://downloads.sourceforge.net/project/newbreeze/1.1.5/NewBreeze.tar.xz"

SRC_URI[md5sum] = "13dd463e522a3cbe3220e73594a664c7"
SRC_URI[sha256sum] = "c964c50650ff3ec5d0e6194f020639e650ce0412dc66cf65fbacd779cec7571c"

S = "${WORKDIR}/NewBreeze"

LDFLAGS = " -lz -L${STAGING_LIBDIR}"
CFLAGS += "-lz -L${STAGING_LIBDIR}"

inherit qt4e autotools pkgconfig

ARM_INSTRUCTION_SET = "arm"

do_install () {
       install -d ${D}${bindir}
       install -m 755 newbreeze ${D}/${bindir}/newbreeze
}

EXTRA_OECONF = "--with-gettext=${STAGING_LIBDIR}/.. \
                --with-zlib=${STAGING_LIBDIR}/.. \
                --with-libxml-dir=${STAGING_BINDIR_CROSS} \
                ${COMMON_EXTRA_OECONF} \
"
EXTRA_OECONF_virtclass-native = " \
                --with-zlib=${STAGING_LIBDIR_NATIVE}/.. \
                --with-libxml-dir=${STAGING_BINDIR_NATIVE} \
                ${COMMON_EXTRA_OECONF} \
"
