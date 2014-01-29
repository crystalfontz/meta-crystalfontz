DESCRIPTION = "Settings demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.5"

inherit allarch

S = "${WORKDIR}/git/settings_apps"

# Make sure setting submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-settings am-sysinfo"

FILES_${PN} += "${MATRIX_BASE_DIR}/*/*/*"
FILES_${PN} += "${S}/*/*"

FILES_${PN} += "/usr/share/matrix-gui-2.0/apps/settings_apps/*"
#FILES_${PN} += "/usr/share/matrix-gui-2.0/apps/games_apps/*"

