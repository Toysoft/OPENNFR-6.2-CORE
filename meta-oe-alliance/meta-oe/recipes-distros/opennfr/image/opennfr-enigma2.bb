DESCRIPTION = "Merge machine and distro options to create a enigma2 machine task/package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "${IMAGE_VERSION}"
PR = "r0"

inherit packagegroup

DEPENDS = "opennfr-feeds"

RDEPENDS_${PN} = "\
    	enigma2-plugin-extensions-autotimer \
	enigma2-plugin-extensions-epgsearch \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-extensions-menusort \
	enigma2-plugin-extensions-customsubservices \
	enigma2-plugin-extensions-infopanel \
	enigma2-plugin-extensions-imdb \
	enigma2-plugin-extensions-mediaportal \	
    	enigma2-plugin-extensions-epgimport \
	\
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-softwaremanager \
	enigma2-plugin-systemplugins-hotplug \
  	\
	enigma2-plugin-skins-opennfrfhd \
	 \
    	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-themes enigma2-plugin-extensions-openwebif-terminal", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "enigma2-plugin-extensions-openwebif-webtv", "enigma2-plugin-extensions-openwebif-vxg", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "boxmodel", "boxmodel" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "videoenhancement", "", "enigma2-plugin-systemplugins-videoenhancement", d)} \
    	${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    	${@bb.utils.contains("MACHINE_FEATURES", "osdanimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    	${@bb.utils.contains("MACHINE_FEATURES", "webkithbbtv", "enigma2-plugin-extensions-webkithbbtv", "", d)} \
    	${@bb.utils.contains("MACHINE_FEATURES", "chromiumos", "enigma2-plugin-extensions-chromium", "", d)} \ 
    	${@bb.utils.contains("MACHINE_FEATURES", "dvd", "bdremux replex mjpegtools dvdauthor dvd+rw-tools cdrkit cdfs cdtextinfo enigma2-plugin-extensions-cdinfo enigma2-plugin-extensions-dvdburn enigma2-plugin-extensions-dvdplayer ${GST_BASE_DVD}", "", d)} \
        ${@bb.utils.contains("TARGET_ARCH", "arm", "glibc-compat", "", d)} \
	"

GST_BASE_DVD = "${@bb.utils.contains('GST_VERSION', '1.0', ' \
    gstreamer1.0-plugins-bad-videoparsersbad \
    gstreamer1.0-plugins-bad-mpegtsmux \
    ', ' \
    gst-plugins-bad-videoparsersbad \
    gst-plugins-bad-mpegtsmux \
    ', d)}"
