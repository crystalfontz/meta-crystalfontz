LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://github.com/crystalfontz/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "7bc9afc5fcee52a53c1ddf3becfadcf9f17c30d1"
BRANCH = "master"
INC_PR = "pr5"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
