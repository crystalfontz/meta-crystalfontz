require recipes-bsp/barebox/barebox.inc

PR = "r1"

SRC_URI = "git://github.com/crystalfontz/barebox \
		   file://defconfig \
"

SRCREV = "ae227f2893c4bf95c1c92d6cde3ebce3687b24a7"

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
