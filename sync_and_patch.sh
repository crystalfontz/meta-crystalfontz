#!/bin/bash

cd sources/poky
git checkout yocto/dora
git checkout bee7e3756adf70edaeabe9d43166707aab84f581
git apply ../meta-crystalfontz/patches/poky_patch.patch
cd ../meta-openembedded/meta-networking
git checkout eb4563b83be0a57ede4269ab19688af6baa62cd2
cd ../../
git apply meta-crystalfontz/patches/meta-oe-php-url.patch
cd meta-fsl-arm
git checkout 2c1519020954dc76c51d9cd4006d7198121501b2
cd ../meta-fsl-arm-extra
git checkout 0512f5fd03033b8ab707fcc8624fac68b79a321d
cd ../meta-fsl-demos
git checkout 430f524fd4113b703181c08f398465ba18d4396c
cd ../meta-java
git checkout 14d6ad1608c66b8970d4052dce4cd1fc64fb6ea2
cd ../meta-qt5
git checkout 5b5616b63bdf163ea3eb2ca8857c56a393435fe3
cd ../meta-crystalfontz/patches
cp 80matchboxkeyboard.sh ../../poky/meta/recipes-sato/matchbox-keyboard/files/
cp matchbox-keyboard-daemon.sh ../../poky/meta/recipes-sato/matchbox-keyboard/files/
mkdir ../../../build
mkdir ../../../build/conf
cp bblayers.conf ../../../build/conf/
cp local.conf ../../../build/conf/
