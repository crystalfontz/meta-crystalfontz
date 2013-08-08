require recipes-bsp/barebox/barebox.inc

PR = "r1"

SRC_URI = "http://barebox.org/download/${PN}-${PV}.tar.bz2"

SRC_URI[md5sum] = "a61b97a2fedebc808d4b182c2ca18a0c"
SRC_URI[sha256sum] = "d9e46dd3c68b04ab4cbc37135dc34907dbebef393da4b3e54abb203c295c1620"

python () {
	if not d.getVar("BAREBOX_MACHINE", True):
		PN = d.getVar("PN", True)
		FILE = os.path.basename(d.getVar("FILE", True))
		bb.debug(1, "To build %s, see %s for instructions on \
			     setting up your machine config" % (PN, FILE))
		raise bb.parse.SkipPackage("BAREBOX_MACHINE is not set in the %s machine configuration." % d.getVar("MACHINE", True))
}

do_pre_configure() {
	oe_runmake ${BAREBOX_MACHINE}
}

do_env_deploy() {
}

COMPATIBLE_MACHINE = "cfa10036"
