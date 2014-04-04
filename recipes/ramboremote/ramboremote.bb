HOMEPAGE = "http://www.crystalfontz.com/"
DESCRIPTION = "QT Embedded 3d printer control GUI application."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=3ddc4261ad4d8743c2880ec7fad049b4"
DEPENDS = "qtserialport-e"

SRC_URI = "http://ftp.hostedftp.com/~baxsie/ramboremote/RamboRemote.tar.gz"

SRC_URI[md5sum] = "7cef79598c25b0731d08ecf365b69e69"
SRC_URI[sha256sum] = "df5a2442709c2ef769a7b5f637855db5098d09989806e060948619f62965cbdf"

S = "${WORKDIR}/RamboRemote"

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
				   /usr/src/debug/ramboremote/1.0-r0/RamboRemote/* \
"
