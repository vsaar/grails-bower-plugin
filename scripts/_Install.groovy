includeTargets << grailsScript("_GrailsEvents")

// initialize bower.json
def bower = classLoader.loadClass('grails.plugin.bower.BowerCommandHelper')

event("StatusUpdate", ["Initializing bower.json"])

if(bower.init()) {
    event("StatusError", ["Initializing bower.json failed"])
} else {
    event("StatusFinal", ["Successfully initialized bower.json"])
}
