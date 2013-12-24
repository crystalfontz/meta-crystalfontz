DESCRIPTION = "Image for Crystalfontz boards"
LICENSE = "MIT"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_INSTALL += " evtest tslib tslib-conf tslib-tests tslib-calibrate tzdata"

IMAGE_LINGUAS = " "

inherit core-image

