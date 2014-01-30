DESCRIPTION = "Extra files for demo-image-cfa"
LICENSE = "GPLv2"
PR = "r2"
S="${WORKDIR}"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c746876a5e2eaefef09efb9d7c1c463d"

SRC_URI += "file://doom.sh \
            file://prboom \
            file://prboom-game-server \
            file://doom1.wad \
            file://prboom.wad \
			file://lib/libpng14.so \
			file://lib/libpng14.so.14 \
			file://lib/libpng14.so.14.12.0 \
			file://lib/libSDL-1.2.so.0 \
			file://lib/libSDL-1.2.so.0.11.4 \
			file://lib/libSDL_mixer-1.2.so.0 \
			file://lib/libSDL_mixer-1.2.so.0.12.0 \
			file://lib/libSDL_mixer.so \
			file://lib/libSDL_net-1.2.so.0 \
			file://lib/libSDL_net-1.2.so.0.8.0 \
			file://lib/libSDL_net.so \
			file://lib/libSDL.so \
			file://lib/lcdproc/* \
"

inherit allarch

do_install () {
    install -m 0755 ${WORKDIR}/doom.sh ${D}/usr/bin
    install -m 0644 ${WORKDIR}/prboom ${D}/usr/games
    install -m 0644 ${WORKDIR}/prboom-game-server ${D}/usr/games
    install -m 0644 ${WORKDIR}/doom1.wad ${D}/usr/share/games/doom
    install -m 0644 ${WORKDIR}/prboom.wad ${D}/usr/share/games/doom
    install -m 0644 ${WORKDIR}/lib/*/* ${D}/usr/lib/
}
