DESCRIPTION = "Games for Matrix v2"
HOMEPAGE = "https://github.com/crystalfontz/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

inherit allarch

S = "${WORKDIR}/git/games_apps"

# Make sure games submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-games"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
