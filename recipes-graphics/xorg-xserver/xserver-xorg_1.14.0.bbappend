FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI_append_cfa10057 = " file://cfa10057-evdev.conf.patch"
SRC_URI_append_cfa10058 = " file://cfa10058-evdev.conf.patch"

