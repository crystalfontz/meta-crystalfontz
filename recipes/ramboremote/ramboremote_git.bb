HOMEPAGE = "http://www.crystalfontz.com/"
DESCRIPTION = "QT Embedded 3d printer control GUI application."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8156b3403995b12675506b785491cd2"
DEPENDS = "qtserialport-e"

SRCREV = "0c4573243572059f3964555321a5172e0a83b8d2"
BRANCH ?= "master"

SRC_URI = " \
    git://github.com/crystalfontz/cfa_rambo_remote.git;protocol=git;branch=${BRANCH} \
"

SRC_URI[md5sum] = "5733f9cbd3d56d50e2f008ae0ec02782"
SRC_URI[sha256sum] = "1c89afe97925ecb457a4274d810c9f1e12def819b1763a288da70aa724d105d5"

S = "${WORKDIR}/git"

LDFLAGS += " -L${STAGING_LIBDIR}"
CFLAGS += " -I${STAGING_INCDIR}"

inherit qt4e autotools pkgconfig 

ARM_INSTRUCTION_SET = "arm"

do_compile () {
       cd ${S}
       qmake && make
}

do_install () {
       install -d ${D}/home/root/Test/
       install -d ${D}${datadir}/applications
       install -m 755 RamboRemote.desktop ${D}/${datadir}/applications/RamboRemote.desktop
       install -m 755 Test.sh ${D}/home/root/Test/Test.sh
       install -m 755 Rambo.sh ${D}/home/root/Test/Rambo.sh
       install -m 755 RamboRemote ${D}/home/root/Test/RamboRemote
       install -m 644 default.ini ${D}/home/root/Test/default.ini
}

FILES_${PN} = "/home/root/Test/* \ 
			   /usr/bin/RamboRemote \
			   /usr/share/applications/RamboRemote.desktop \
"

FILES_${PN}-dbg = "/home/root/Test/.debug/* \
				   /usr/src/debug/ramboremote/git-r0/git/* \
"
