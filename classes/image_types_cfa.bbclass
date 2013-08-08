inherit image_types

IMAGE_BOOTLOADER ?= "barebox"

IMAGE_DEPENDS_barebox.sb = "elftosb-native mx28-bcb-native imx-bootlets barebox"
IMAGE_LINK_NAME_barebox.sb = ""
IMAGE_CMD_barebox.sb () {
	barebox_bd_file=imx-bootlets-barebox_ivt.bd-${MACHINE}

	# Ensure the file is generated
	rm -f ${IMAGE_NAME}.barebox.sb
	elftosb -f mx28 -z -c $barebox_bd_file -o ${IMAGE_NAME}.barebox.sb
}

# Barebox environment size [in KiB]
BAREBOX_ENV_SPACE ?= "512"

# Set alignment to 4MB [in KiB]
IMAGE_ROOTFS_ALIGNMENT = "4096"

IMAGE_DEPENDS_sdcard = "parted-native dosfstools-native mtools-native \
                        virtual/kernel ${IMAGE_BOOTLOADER}"

SDCARD = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.sdcard"

SDCARD_GENERATION_COMMAND_cfa10036 = "generate_cfa_sdcard"

generate_cfa_sdcard () {
	# Create partition table
	parted -s ${SDCARD} mklabel msdos

	case "${IMAGE_BOOTLOADER}" in
		barebox)
		# 0      1024      1024 + 32MiB      1024 + 8Mib + SDIMG_ROOTFS      1024 + 8MiB + SDIMG_ROOTFS + 4MiB
		parted -s ${SDCARD} unit KiB mkpart primary 1024 $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED} - ${BAREBOX_ENV_SPACE})
		parted -s ${SDCARD} unit KiB mkpart primary $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED} - ${BAREBOX_ENV_SPACE}) $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED})
		parted -s ${SDCARD} unit KiB mkpart primary $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED}) $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED} \+ $ROOTFS_SIZE)


		mx28_bcb.py --bootstream ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.barebox.sb --start 2048 ${SDCARD}
		;;
		*)
		bberror "Unkown IMAGE_BOOTLOADER value"
		exit 1
		;;
	esac

	# Change partition type for mxs processor family
	bbnote "Setting partition type to 0x53 as required for mxs' SoC family."
	echo -n S | dd of=${SDCARD} bs=1 count=1 seek=450 conv=notrunc

	parted ${SDCARD} print

	dd if=${SDCARD_ROOTFS} of=${SDCARD} conv=notrunc seek=1 bs=$(expr ${BOOT_SPACE_ALIGNED} \* 1024 + ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync
}

