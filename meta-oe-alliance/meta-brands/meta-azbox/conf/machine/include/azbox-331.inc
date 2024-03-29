# We know about rtc
include conf/machine/include/build-extras.inc

BRAND_OEM = "azbox"
MACHINE_BRAND = "AZBOX"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS = " \
    azbox-dvb-modules-331 \
    "

DVBPROVIDER = "kernel"

MACHINE_EXTRA_RRECOMMENDS = " \
    gstreamer1.0-plugin-azbox-dvbmediasink \
    azbox-compat \
    kernel-module-cifs \
    "

DVBMEDIASINK_CONFIG = "--with-wma --with-wmv --with-pcm --with-dtsdownmix --with-azbox"

MACHINE_FEATURES += " kernel26 alsa usbhost wifi nl80211 3dtv switchoff lpcm textlcd 32bpp hdtv dvbapi5 dvb-c blindscan-dvbs boxmodel"

PREFERRED_VERSION_linux-azbox = "3.3.1"
PREFERRED_VERSION_linux-libc-headers = "3.3"

PREFERRED_VERSION_rt8812au = "4.3.14"

GLIBC_EXTRA_OECONF = "--with-tls --with-__thread"

PREFERRED_PROVIDER_virtual/kernel = "linux-azbox"
PREFERRED_PROVIDER_virtual/blindscan-dvbs = "azbox-blindscan-dvbs-utils"

require conf/machine/include/tune-mips32.inc
require conf/machine/include/soc-family.inc
include conf/machine/include/autoload-filesystems.inc

SYSVINIT_ENABLED_GETTYS = ""

EXTRA_IMAGEDEPENDS += " \
    enigma2-plugin-systemplugins-rtisys \
    enigma2-plugin-systemplugins-videosettingssetup \
    kmod \
    "

MACHINE_EXTRA_RDEPENDS = " \
    enigma2-plugin-systemplugins-rtisys \
    enigma2-plugin-systemplugins-videosettingssetup \
    "

# Add "MACHINEBUILD" override for recipes
MACHINEOVERRIDES =. "${@['', '${MACHINEBUILD}:']['${MACHINEBUILD}' != '']}"