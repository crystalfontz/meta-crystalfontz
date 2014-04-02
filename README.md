meta-crystalfontz
=================

Crystalfontz yocto/openembedded layer

This layer depends on:

URI: git://git.openembedded.org/openembedded-core
branch: master
revision: HEAD

URI: git://git.openembedded.org/meta-openembedded
branch: master
revision: HEAD

URI: git://github.com/woglinde/meta-java
branch: master
revision: HEAD

URI: git://git.yoctoproject.com/meta-fsl-arm
branch: dora
revision: HEAD

URI: git://github.com/meta-qt5/meta-qt5
branch: master
revision: HEAD

URI: git://github.com/Freescale/meta-fsl-demos
branch: dora
revision: HEAD


For meta-java, you'll need to define in local.conf the following:
PREFERRED_PROVIDER_virtual/java-initial = "cacao-initial"

PREFERRED_PROVIDER_virtual/java-native = "jamvm-native"
PREFERRED_PROVIDER_virtual/javac-native = "ecj-bootstrap-native"

For openjdk6:
PREFERRED_VERSION_openjdk-6-jre = "6b24-1.11.9"
or
PREFERRED_VERSION_openjdk-6-jre = "6b27-1.12.5"
PREFERRED_VERSION_icedtea6-native = "1.8.11"

For openjdk7:
PREFERRED_VERSION_openjdk-7-jre = "25b30-2.3.12"
PREFERRED_VERSION_icedtea7-native = "2.1.3"

Sometimes the following is needed:
PREFERRED_PROVIDER_openjdk-6-jre = "openjdk-6-jre"
PREFERRED_PROVIDER_openjdk-7-jre = "openjdk-7-jre

