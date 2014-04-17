add_custom_smart_config() {
        smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart channel --add crystalfontz type=rpm-md name="Crystalfontz Package Repository" baseurl=https://packages.crystalfontz.com/master/ -y
}

ROOTFS_POSTPROCESS_COMMAND =+ "add_custom_smart_config ;"
