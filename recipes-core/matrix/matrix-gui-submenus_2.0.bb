DESCRIPTION = "Submenu packages for Matrix GUI v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc
require matrix-gui-paths.inc

# This package does not use a subdirectory as ${S} so we need to
# reset the LIC_FILES_CHKSUM setting from the matrix-gui-apps-git.inc file
LIC_FILES_CHKSUM = "file://LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"

PR = "${INC_PR}.11"

# These packages make submenus in matrix and are not architecture specific
inherit allarch

S = "${WORKDIR}/git"

# List of submenus to build packages for
SUBMENUS = "arm_submenu 3d_submenu cryptos_submenu games_submenu qt4_submenu settings_submenu wifi_submenu oprofile_submenu"

INSANE_SKIP_${PN} = "True"

do_install(){
    install -d ${D}${MATRIX_APP_DIR}

    for x in ${SUBMENUS}
    do
        cp -rf ${S}/$x ${D}${MATRIX_APP_DIR}/
    done
}

PACKAGES += "${PN}-arm ${PN}-3d ${PN}-cryptos ${PN}-qt4 ${PN}-settings ${PN}-wifi ${PN}-oprofile"

FILES_${PN} += "/usr/share/matrix-gui-2.0/apps/3d_apps/*"
FILES_${PN} += "/usr/share/matrix-gui-2.0/apps/*/*/*"
FILES_${PN} += "/usr/share/matrix-gui-2.0/apps/games_apps/*"
FILES_${PN} += "/usr/share/matrix-gui-2.0/apps/games_submenu/*"



# Make sure app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images"

# Add the files for each submenu package
FILES_${PN}-arm = "${MATRIX_APP_DIR}/arm_submenu/*"
FILES_${PN}-3d = "${MATRIX_APP_DIR}/3d_submenu/*"
FILES_${PN}-cryptos = "${MATRIX_APP_DIR}/cryptos_submenu/*"
FILES_${PN}-qt4 = "${MATRIX_APP_DIR}/qt4_submenu/*"
FILES_${PN}-settings = "${MATRIX_APP_DIR}/settings_submenu/*"
FILES_${PN}-wifi = "${MATRIX_APP_DIR}/wifi_submenu/*"
FILES_${PN}-oprofile = "${MATRIX_APP_DIR}/oprofile_submenu/*"
FILES_${PN}-games = "${MATRIX_APP_DIR}/games_submenu/*"
