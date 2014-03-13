# Disable services that are enabled by default, but not necessary for an 
# image to be useful (want in the image, but not running by default)
# disable nfs server
ROOTFS_POSTPROCESS_COMMAND = "mv ${IMAGE_ROOTFS}/etc/rc2.d/S20nfsserver ${IMAGE_ROOTFS}/etc/rc2.d/K20nfsserver;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc3.d/S20nfsserver ${IMAGE_ROOTFS}/etc/rc3.d/K20nfsserver;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc4.d/S20nfsserver ${IMAGE_ROOTFS}/etc/rc4.d/K20nfsserver;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc5.d/S20nfsserver ${IMAGE_ROOTFS}/etc/rc5.d/K20nfsserver;"

# disable distcc
ROOTFS_POSTPROCESS_COMMAND = "mv ${IMAGE_ROOTFS}/etc/rc2.d/S20distcc ${IMAGE_ROOTFS}/etc/rc2.d/K20distcc;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc3.d/S20distcc ${IMAGE_ROOTFS}/etc/rc3.d/K20distcc;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc4.d/S20distcc ${IMAGE_ROOTFS}/etc/rc4.d/K20distcc;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc5.d/S20distcc ${IMAGE_ROOTFS}/etc/rc5.d/K20distcc;"

# deploy licenses to the target
ROOTFS_POSTPROCESS_COMMAND += "license_create_manifest"

ROOTFS_POSTPROCESS_COMMAND += "write_image_manifest"
