DESCRIPTION = "i.MXS boot streams"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR = "r1"

SRC_URI = "git://github.com/crystalfontz/bootlets.git \
		   file://barebox-fix-paths.patch \
		  "
SRCREV = "03bfdef0fa7efc6b64392e3eebfaf688018751cc"

S = "${WORKDIR}/git"

# Disable parallel building or it may fail to build.
PARALLEL_MAKE = ""

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

# Ensure machine defines the IMXBOOTLETS_MACHINE
python () {
	if not d.getVar("IMXBOOTLETS_MACHINE", True):
		PN = d.getVar("PN", True)
		FILE = os.path.basename(d.getVar("FILE", True))
		bb.debug(1, "To build %s, see %s for instructions on \
			     setting up your machine config" % (PN, FILE))
		raise bb.parse.SkipPackage("because IMXBOOTLETS_MACHINE is not set")
}

do_configure () {
    sed -i 's,@MACHINE@,${MACHINE},g' barebox_ivt.bd
}

do_compile () {
    oe_runmake BOARD=${IMXBOOTLETS_MACHINE} linux_prep \
                                            boot_prep \
                                            power_prep
}

do_install () {
    install -d ${D}/boot/
    install -m 644 boot_prep/boot_prep power_prep/power_prep \
                   barebox_ivt.bd \
                   ${D}/boot
}

FILES_${PN} = "/boot"

do_deploy () {
    install -d ${DEPLOY_DIR_IMAGE}

	for f in boot_prep/boot_prep \
             power_prep/power_prep \
             barebox_ivt.bd; do
        full_name="imx-bootlets-`basename $f`-${MACHINE}-${PV}-${PR}"
        symlink_name="imx-bootlets-`basename $f`-${MACHINE}"

        install -m 644 ${S}/$f ${DEPLOY_DIR_IMAGE}/$full_name
        (cd ${DEPLOY_DIR_IMAGE} ; rm -f $symlink_nake ; ln -sf $full_name $symlink_name)
    done
}

addtask deploy before do_build after do_compile

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mxs)"
