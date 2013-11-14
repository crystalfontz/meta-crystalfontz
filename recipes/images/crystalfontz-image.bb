DESCRIPTION = "Image for Crystalfontz boards"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_INSTALL += "kernel-image kernel-devicetree"

IMAGE_INSTALL += "python-core"

IMAGE_INSTALL += "gtk+ systemtap systemtap-uprobes evtest linux-firmware bzip2 libsdl libsdl-mixer libsdl-image tslib tslib-conf tslib-tests tslib-calibrate cairo libpng webkit-gtk qt4-tools qt4-examples midori gcc nano mono openjdk-7-jre python-pyserial python-pyqt python-pygtk python-numeric wxpython wxwidgets python-tkinter libjson qextserialport json-glib python-json python-pyopenssl python-pygtk tzdata qconnman wireless-tools florence matchbox-keyboard-im i2c-tools tzdata"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

