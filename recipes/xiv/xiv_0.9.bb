HOMEPAGE = "http://sourceforge.net/projects/xiv/"
DESCRIPTION = "Fast and light-weight File Manager."
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=daa273295f57ee294a0006e06131b4ad"

PR = "r0"

DEPENDS_${PN} = "virtual/libx11 jpeg tiff exif"

SRC_URI = "http://downloads.sourceforge.net/project/xiv/xiv-0.9.tgz"

SRC_URI[md5sum] = "83f86c2071b97d15c52f404f1947c2d4"
SRC_URI[sha256sum] = "9eeb295ec640f09681f7b21ac045aaf7144d5d3b417f8d4c301bfa3887d9527c"

S = "${WORKDIR}/xiv-0.9"

LDFLAGS += " -lz -L${STAGING_LIBDIR}"
CFLAGS += "-lz -I${STAGING_INCDIR}"

inherit autotools pkgconfig binconfig 

do_install () {
       install -d ${D}${bindir}
       install -m 755 xiv ${D}/${bindir}/xiv
}

