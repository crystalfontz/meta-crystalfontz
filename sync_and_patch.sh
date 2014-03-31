#!/bin/bash

chmod a+x setup-environment
MACHINE=cfa100xx ./setup-environment build

filepath=`pwd`

cd $filepath/sources/poky
git checkout yocto/dora
git checkout bee7e3756adf70edaeabe9d43166707aab84f581
echo "applying patches to yocto repository"
git apply $filepath/sources/meta-crystalfontz/patches/poky_patch.patch
cd $filepath/sources/meta-openembedded
git checkout eb4563b83be0a57ede4269ab19688af6baa62cd2
echo "applying patches to meta-openembedded repository"
git apply $filepath/sources/meta-crystalfontz/patches/meta-oe-php-url.patch
cd $filepath/sources/meta-fsl-arm
git checkout 2c1519020954dc76c51d9cd4006d7198121501b2
cd $filepath/sources/meta-fsl-arm-extra
git checkout 0512f5fd03033b8ab707fcc8624fac68b79a321d
cd $filepath/sources/meta-fsl-demos
git checkout 430f524fd4113b703181c08f398465ba18d4396c
cd $filepath/sources/meta-java
git checkout de06956f93ecd15d8c941a05da47a4425e3d397a
cd $filepath/sources/meta-qt5
git checkout 5b5616b63bdf163ea3eb2ca8857c56a393435fe3
cd $filepath/sources/meta-crystalfontz/patches
if [ ! -e $filepath/sources/poky/meta/recipes-sato/matchbox-keyboard/files/80matchboxkeyboard.sh ]; then
cp 80matchboxkeyboard.sh $filepath/sources/poky/meta/recipes-sato/matchbox-keyboard/files/
fi
if [ ! -e $filepath/sources/poky/meta/recipes-sato/matchbox-keyboard/files/matchbox-keyboard-daemon.sh ]; then
cp matchbox-keyboard-daemon.sh $filepath/sources/poky/meta/recipes-sato/matchbox-keyboard/files/
fi
if [ ! -d $filepath/build ]; then
mkdir $filepath/build
fi
if [ ! -d $filepath/build/conf ]; then
mkdir $filepath/build/conf
fi
if [ -d $filepath/build/conf ]; then
cp bblayers.conf $filepath/build/conf/
cp local.conf $filepath/build/conf/
fi

export PATH=$PATH:$filepath/sources/poky/bitbake/bin/

cd $filepath/build
