LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://github.com/crystalfontz/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "7ec5b26618fdea06c92a1b23e5e6864301988d52"
BRANCH = "master"
INC_PR = "r2"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc