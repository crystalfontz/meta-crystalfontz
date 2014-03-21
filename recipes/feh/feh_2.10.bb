SECTION = "x11/utils"
DESCRIPTION = "feh is a fast, lightweight image viewer which uses imlib2."
HOMEPAGE = "http://feh.finalrewind.org/"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=364a0fbae4ab4bac979efa128780258a"

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-dev"

DEPENDS = " virtual/imlib2 giblib jpeg virtual/libx11 libxext libxt"

SRC_URI = "http://feh.finalrewind.org/feh-${PV}.tar.bz2 \
		   file://events.patch \
		   file://buttons \
		  " 

S = "${WORKDIR}/feh-${PV}"

inherit autotools

SRC_URI[md5sum] = "6714dedeff1db5c3593c4a27b0d9cf50"
SRC_URI[sha256sum] = "bc782a884eedd7a73284804d8145238f140fa59fed8d483102d1d25e8144ca83"

LDFLAGS = " -L${STAGING_LIBDIR}"

FILES_${PN} = "/usr/local/bin/* \
			   /usr/local/share/* \
			   /usr/local/share/doc/* \
			   /usr/local/share/feh/* \
			   /usr/local/share/man/man1/* \
			   /home/root/.config/feh/* \
			   "
			   
FILES_${PN}-dbg += "/usr/local/bin/.debug/*"

do_install_append() {
    install -d ${D}/home/root/.config
    install -d ${D}/home/root/.config/feh
    cp -r ${FILE_DIRNAME}/files/buttons ${D}/home/root/.config/feh/
}
