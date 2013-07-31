DESCRIPTION = "Image for Crystalfontz boards"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"


IMAGE_INSTALL += "python-core"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

