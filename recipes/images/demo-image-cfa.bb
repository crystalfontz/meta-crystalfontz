DESCRIPTION = "Image for Crystalfontz boards"
LICENSE = "MIT"

IMAGE_FEATURES += "splash package-management x11-base x11-sato ssh-server-dropbear hwcodecs"

inherit core-image

IMAGE_INSTALL += " init-ifupdown busybox-udhcpd"

IMAGE_INSTALL += "packagegroup-core-x11-sato-games"

IMAGE_INSTALL += " evtest tslib tslib-conf tslib-tests tslib-calibrate tzdata xev"

