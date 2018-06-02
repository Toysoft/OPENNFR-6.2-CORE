DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-plugins-good.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://gst/replaygain/rganalysis.c;beginline=1;endline=23;md5=b60ebefd5b2f5a8e0cab6bfee391a5fe \
"

UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>(\d+(\.\d+)+))"

SRCREV_base = "0fbde2a07928ba79b7a4ddb4585f6b1de36a74bb"
SRCREV_common = "46d420818ed8172022caf4503894076b18b1e153"
SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-good;branch=master;name=base \
           git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
           file://0001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch \
           file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
"

S = "${WORKDIR}/git"

GST_VERSION_FULL ="1.14.1"
inherit gitpkgv
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"

CFLAGS_append += " -Wno-maybe-uninitialized -Wno-uninitialized -Wno-incompatible-pointer-types"

RPROVIDES_${PN}-pulseaudio += "${PN}-pulse"
RPROVIDES_${PN}-soup += "${PN}-souphttpsrc"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}
