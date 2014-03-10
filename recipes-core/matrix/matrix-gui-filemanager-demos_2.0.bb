DESCRIPTION = "File Manager demo descriptions for Matrix v2"
HOMEPAGE = "https://github.com/crystalfontz/matrix-gui-v2"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/filemanager_apps"

# Make sure setting submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-filemanager am-sysinfo"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

FILES_${PN} += "/usr/share/matrix-gui-2.0/apps/filemanager_apps/*"
