SUMMARY = "Start, stop and select cardservers."
MAINTAINER = "PLi team"
inherit allarch

require conf/license/license-gplv2.inc

PACKAGES = "${PN}"

PV = "1.0"
PR = "r0"

INITSCRIPT_NAME = "cardserver"
INITSCRIPT_PARAMS = "start 45 S ."
inherit update-rc.d

do_install() {
    install -d ${D}/etc/init.d
    install -m 755 ${S}/cardserver.None ${D}/etc/init.d/cardserver.None
    ln -s cardserver.None ${D}/etc/init.d/cardserver
}

do_compile_append() {
    echo "# Placeholder for no cs" > ${S}/cardserver.None
}
