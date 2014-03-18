# Disable services that are enabled by default, but not necessary for an 
# image to be useful (want in the image, but not running by default)

#move_demo_images () {
#	cd ${OEBASE}
#	pwd
#	cd sources/meta-crystalfontz/
#	cp -r cfa-prebuilt/cfa-prebuilt/images ${IMAGE_ROOTFS}/home/root/
#}

deploy_manifests () {
	cd ${DEPLOY_DIR}/licenses
	cp ${IMAGE_NAME}/license.manifest ${IMAGE_ROOTFS}/etc/license.manifest
	cp ${IMAGE_NAME}/package.manifest ${IMAGE_ROOTFS}/etc/package.manifest
}

# disable nfs server
#ROOTFS_POSTPROCESS_COMMAND = "mv ${IMAGE_ROOTFS}/etc/rc2.d/S20nfsserver ${IMAGE_ROOTFS}/etc/rc2.d/K20nfsserver;"
#ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc3.d/S20nfsserver ${IMAGE_ROOTFS}/etc/rc3.d/K20nfsserver;"
#ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc4.d/S20nfsserver ${IMAGE_ROOTFS}/etc/rc4.d/K20nfsserver;"
#ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc5.d/S20nfsserver ${IMAGE_ROOTFS}/etc/rc5.d/K20nfsserver;"

# disable distcc
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc2.d/S20distcc ${IMAGE_ROOTFS}/etc/rc2.d/K20distcc;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc3.d/S20distcc ${IMAGE_ROOTFS}/etc/rc3.d/K20distcc;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc4.d/S20distcc ${IMAGE_ROOTFS}/etc/rc4.d/K20distcc;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc5.d/S20distcc ${IMAGE_ROOTFS}/etc/rc5.d/K20distcc;"

# disable matrix-gui
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc2.d/S97matrix-gui-2.0 ${IMAGE_ROOTFS}/etc/rc2.d/K97matrix-gui-2.0;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc3.d/S97matrix-gui-2.0 ${IMAGE_ROOTFS}/etc/rc3.d/K97matrix-gui-2.0;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc4.d/S97matrix-gui-2.0 ${IMAGE_ROOTFS}/etc/rc4.d/K97matrix-gui-2.0;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rc5.d/S97matrix-gui-2.0 ${IMAGE_ROOTFS}/etc/rc5.d/K97matrix-gui-2.0;"

# move some stuff around init.d
ROOTFS_POSTPROCESS_COMMAND += "mkdir ${IMAGE_ROOTFS}/etc/init.d_disabled;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/init.d/ofono ${IMAGE_ROOTFS}/etc/init.d_disabled/;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/init.d/matrix-gui-2.0 ${IMAGE_ROOTFS}/etc/init.d_disabled/;"
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/init.d/lighttpd ${IMAGE_ROOTFS}/etc/init.d_disabled/;"

# fix psplash.sh in /etc/rcS.d to be S01psplash.sh so that we can run our 
# configuration script just prior to set things like the touchscreen, rotation
# of the screen and the splash screen
ROOTFS_POSTPROCESS_COMMAND += "mv ${IMAGE_ROOTFS}/etc/rcS.d/S00psplash.sh ${IMAGE_ROOTFS}/etc/rcS.d/S01psplash.sh;"
ROOTFS_POSTPROCESS_COMMAND += "cp ${IMAGE_ROOTFS}/etc/rcS.d/S00cfa-preconfig.sh ${IMAGE_ROOTFS}/etc/init.d/cfa-preconfig.sh;"

# deploy manifest files to the target
ROOTFS_POSTPROCESS_COMMAND += "deploy_manifests"

# deploy all the images to cover all builds to the target for the slideshow, et cetera.
#ROOTFS_POSTPROCESS_COMMAND += "move_demo_images"



