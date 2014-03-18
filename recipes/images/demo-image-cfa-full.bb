include recipes-sato/images/core-image-sato.bb

inherit demo_image_cfa license image debian

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

IMAGE_ROOTFS_EXTRA_SPACE="1000000"

DISTRO_FEATURES = "pam"

IMAGE_FEATURES += "debug-tweaks package-management splash"
WEB = "web-webkit"

EXTRA_IMAGE_FEATURES += " \
    qt4-pkgs \
	ssh-server-dropbear \
	package-management \
	hwcodecs \
	tools-debug \
	tools-profile \
	dev-pkgs \
	tools-sdk \
"

# splash screen, process management 
IMAGE_INSTALL += " \
	psplash \
	psmisc \
	procps \
"

# laziness / other
IMAGE_INSTALL += " \
	cfa-prebuilt \
"

# Kernel related
IMAGE_INSTALL += " \
	linux-firmware \
	kernel-modules \
"

# Networking related
IMAGE_INSTALL += " \
	iw \
	connman-client \
	wireless-tools \
	init-ifupdown \
	busybox-udhcpd \
	wpa-supplicant \
	openssh-sftp-server \
	openssh-sftp \
	wpa-gui-e \
	mosh \
"

# Hardware related
IMAGE_INSTALL += " \
	evtest \ 
	tslib \
	tslib-conf \
	tslib-tests \
	tslib-calibrate \
	xev \
    cpufrequtils \
	devmem2 \
	i2c-tools \
	traceroute \
	uvccapture \
"

IMAGE_INSTALL += " \
	evince \
    nano \
	emacs \
    fbv \
    minicom \
    packagegroup-qt-in-use-demos \
    qt4-demos \
    qt4-examples \
    cfa-config-extra \
	tzdata \
	gimp \
	feh \
"

# development / etc.
IMAGE_INSTALL += " \
	python-pyserial \
	python-pyusb \
	python-simplejson \
	python-pyudev \
	nano \
	mono \
	openjdk-7-jre \
	screen \
	libpng \
"

# low-level games support / games
IMAGE_INSTALL += " \
	libsdl \
	libsdl-dev \
	libsdl-ttf \
	libsdl-mixer \
	libsdl-image \
	libsdl-net \
	libsdl-gfx \
	prboom \
"

#pure QT launcher, ported from TI's arago distro
IMAGE_INSTALL += " \
	matrix-gui \
	matrix-gui-browser \
	matrix-gui-settings-demos \
	matrix-gui-wifi-demos \
	matrix-gui-games-demos \
	matrix-gui-qt4-demos \
	matrix-gui-filemanager-demos \
"
	
export IMAGE_BASENAME = "demo-image-cfa-full"
