#!/bin/bash

cd sources/poky
git checkout bee7e3756adf70edaeabe9d43166707aab84f581
git apply ../meta-crystalfontz/patches/0001-kernel-use-oldnoconfig-instead-of-yes-make-oldconfig.patch
git apply ../meta-crystalfontz/patches/0002-matchbox-keyboard-daemonize-launch.patch
git apply ../meta-crystalfontz/patches/0003-wpa-supplicant-2.0-don-t-exit-in-pkg_postinst.patch
cd ../meta-openembedded/meta-networking
git checkout eb4563b83be0a57ede4269ab19688af6baa62cd2
cd ../../meta-fsl-arm
git checkout 2c1519020954dc76c51d9cd4006d7198121501b2
cd ../meta-fsl-arm-extra
git checkout 0512f5fd03033b8ab707fcc8624fac68b79a321d
cd ../meta-fsl-demos
git checkout 430f524fd4113b703181c08f398465ba18d4396c
cd ../meta-java
git checkout 14d6ad1608c66b8970d4052dce4cd1fc64fb6ea2
cd ../meta-qt5
git checkout 5b5616b63bdf163ea3eb2ca8857c56a393435fe3
