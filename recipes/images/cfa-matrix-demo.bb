DESCRIPTION = "Matrix Image for Crystalfontz boards"
LICENSE = "MIT"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_INSTALL += " linux-firmware init-ifupdown busybox-udhcpd"

EXTRA_IMAGE_FEATURES += " \
    nfs-server \
	ssh-server-dropbear \
	package-management \
	hwcodecs \
	tools-debug \
	tools-profile \
	dev-pkgs \
	tools-sdk \
"

IMAGE_INSTALL += " evtest tslib tslib-conf tslib-tests tslib-calibrate"
IMAGE_INSTALL += " devmem2 wireless-tools i2c-tools tzdata wpa-supplicant"
IMAGE_INSTALL += " nano mono openjdk-7-jre lcdproc lcdd screen libsdl-dev"
IMAGE_INSTALL += " libsdl-mixer openssh-sftp openssh-sftp-server"


IMAGE_LINGUAS = " "

IMAGE_INSTALL += " \
    cpufrequtils \
    nano \
    packagegroup-qt-in-use-demos \
    packagegroup-core-qt4e \
    qt4-embedded-demos \
    qt4-embedded-examples \
    qt4-embedded-dev \
    qt4-embedded \
    packagegroup-qte-toolchain-target \
    devmem2 \
    tcpdump \
    curl \
    ethtool \
    qt4-embedded-plugin-mousedriver-tslib \
    qt4-embedded-plugin-gfxdriver-gfxtransformed \
    qt4-embedded-plugin-phonon-backend-gstreamer \
    qt4-embedded-plugin-imageformat-gif \
    qt4-embedded-plugin-imageformat-jpeg \
    qt4-embedded-qml-plugins \
    qtdeclarative \
"

inherit core-image

