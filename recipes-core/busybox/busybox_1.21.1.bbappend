FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_cfa10036 = " \
   file://udhcpd.conf \
"

do_install_append_cfa10036 () {
    install -m 0755 ${WORKDIR}/udhcpd.conf ${D}${sysconfdir}/
}
