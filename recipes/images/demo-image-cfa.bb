include recipes-sato/images/core-image-sato.bb

IMAGE_FEATURES += "debug-tweaks"
WEB = "web-webkit"

IMAGE_INSTALL += " linux-firmware init-ifupdown busybox-udhcpd"

# we don't need the full tools-testapps
IMAGE_INSTALL += " evtest tslib tslib-conf tslib-tests tslib-calibrate xev"
IMAGE_INSTALL += " iw connman-client"

EXTRA_IMAGE_FEATURES += " \
    nfs-server \
    qt4-pkgs \
"

# more debugging and profiling
EXTRA_IMAGE_FEATURES += " \
    tools-debug \
    tools-profile \
"

IMAGE_INSTALL += " \
    cpufrequtils \
    nano \
    packagegroup-qt-in-use-demos \
    qt4-demos \
    qt4-examples \
    cfa-config-extra \
    "

export IMAGE_BASENAME = "demo-image-cfa"
