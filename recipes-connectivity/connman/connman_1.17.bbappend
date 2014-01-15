FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://connman.defaults"

do_install_append() {
	if ${@base_contains('DISTRO_FEATURES','sysvinit','true','false',d)}; then
		install -d ${D}${sysconfdir}/default
		install -m 0755 ${WORKDIR}/connman.defaults ${D}${sysconfdir}/default/connman
	fi
}
