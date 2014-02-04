LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://github.com/crystalfontz/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "b9f797679bdc9e2af1c731ede1a810c1faa291d6"
BRANCH = "master"
INC_PR = "r8"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
