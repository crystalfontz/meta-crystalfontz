LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://github.com/crystalfontz/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "3adb956284b14ac71e3bd9dc53becfc3a58c15ec"
BRANCH = "master"
INC_PR = "r7"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
