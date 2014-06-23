include recipes-sato/images/core-image-sato.bb

inherit demo_image_cfa cfa_smart_config license image debian

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
    tools-testapps \
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

# Testing/benchmarking
IMAGE_INSTALL += " \
	bonnie-scripts \
	dbench \
	iperf \
	lmbench \
	memtester \
	nbench-byte \
	ethtool \
	traceroute \
	sysstat \
	stat \
	ltp \
	pv \
	tcpdump \
	inetutils \
	netcat \
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
	uvccapture \
	xf86-input-evdev \
"

IMAGE_INSTALL += " \
	evince \
    nano \
	emacs \
    fbv \
    minicom \
    packagegroup-qt-in-use-demos \
    qtserialport-e-dev \
    qt4-embedded-demos \
    qt4-embedded-examples \
    qt4-embedded-dev \
    qt4-embedded-plugin-mousedriver-tslib \
    qt4-embedded-plugin-gfxdriver-gfxtransformed \
    qt4-embedded-plugin-phonon-backend-gstreamer \
    qt4-embedded-plugin-imageformat-gif \
    qt4-embedded-plugin-imageformat-jpeg \
    qt4-embedded-qml-plugins \
    cfa-config-extra \
	tzdata \
	ntp \
	xiv \
	eog \
	ramboremote \
"

# development / etc.
IMAGE_INSTALL += " \
	python-pyserial \
	python-pyusb \
	python-simplejson \
	python-pyudev \
	git \
	subversion \
	nano \
	mono \
	openjdk-7-jre \
	screen \
	libpng \
	packagegroup-qte-toolchain-target \
    geany \
	libqt-embedded3support4-dev \
	libqt-embeddedclucene4-dev \
	libqt-embeddedcore4-dev \
	libqt-embeddeddbus4-dev \
	libqt-embeddeddeclarative4-dev \
	libqt-embeddeddesigner4-dev \
	libqt-embeddeddesignercomponents4-dev \
	libqt-embeddedgui4-dev \
	libqt-embeddedhelp4-dev \
	libqt-embeddedmultimedia4-dev \
	libqt-embeddednetwork4-dev \
	libqt-embeddedphonon4-dev \
	libqt-embeddedscript4-dev \
	libqt-embeddedscripttools4-dev \
	libqt-embeddedsql4-dev \
	libqt-embeddedsvg4-dev \
	libqt-embeddedtest4-dev \
	libqt-embeddeduitools4-dev \
	libqt-embeddedwebkit4-dev \
	libqt-embeddedxml4-dev \
	libqt-embeddedxmlpatterns4-dev \
	libqt3support4-dev \
	libqtclucene4-dev \
	libqtcore4-dev \
	libqtdbus4-dev \
	libqtdeclarative4-dev \
	libqtdesigner4-dev \
	libqtdesignercomponents4-dev \
	libqtgui4-dev \
	libqthelp4-dev \
	libqtmultimedia4-dev \
	libqtnetwork4-dev \
	libqtopengl4-dev \
	libqtphonon4-dev \
	libqtscript4-dev \
	libqtscripttools4-dev \
	libqtsql4-dev \
	libqtsvg4-dev \
	libqttest4-dev \
	libqtuitools4-dev \
	libqtwebkit4-dev \
	libqtxml4-dev \
	libqtxmlpatterns4-dev \
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
