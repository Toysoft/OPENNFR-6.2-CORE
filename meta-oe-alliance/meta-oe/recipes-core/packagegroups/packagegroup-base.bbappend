
PACKAGES += " \
            ${@bb.utils.contains("DISTRO_FEATURES", "smbfs", "packagegroup-base-smbfs-client", "", d)} \
            ${@bb.utils.contains("DISTRO_FEATURES", "smbfs", "packagegroup-base-smbfs-server", "", d)} \
            ${@bb.utils.contains("DISTRO_FEATURES", "smbfs", "packagegroup-base-samba", "", d)} \
            "

RDEPENDS_packagegroup-base := "${@oe_filter_out('packagegroup-base-nfs', '${RDEPENDS_packagegroup-base}', d)}"
RDEPENDS_packagegroup-base := "${@oe_filter_out('packagegroup-base-smbfs', '${RDEPENDS_packagegroup-base}', d)}"

RDEPENDS_packagegroup-base-smbfs += "\
    cifs-utils \
    "

RDEPENDS_packagegroup-base-smbfs-client = "\
    packagegroup-base-smbfs \
    smbclient \
    "

RDEPENDS_packagegroup-base-smbfs-server = "\
    samba-base \
    "

RRECOMMENDS_packagegroup-base-samba = "\
    packagegroup-base-smbfs \
    packagegroup-base-smbfs-client \
    packagegroup-base-smbfs-server \
    "

RDEPENDS_packagegroup-base-nfs += "\
    nfs-utils \
    nfs-utils-client"

RDEPENDS_packagegroup-base-zeroconf += "\
    libnss-llmnr"

RDEPENDS_packagegroup-base += "\
    coreutils-truefalse \
    stb-hwclock \
    fake-hwclock"
