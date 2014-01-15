FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://wpa_supplicant"

INITSCRIPT_NAME = "wpa_supplicant"
INITSCRIPT_PARAMS = "start 06 5 2 3 . stop 21 0 1 6 ."

inherit update-rc.d

do_install_append() {
       if ${@base_contains('DISTRO_FEATURES','sysvinit','true','false',d)}; then
               install -d ${D}${sysconfdir}/init.d
               install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
       fi
}
