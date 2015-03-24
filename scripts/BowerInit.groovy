includeTargets << grailsScript("_GrailsBootstrap")

// initialize bower.json
target(bowerInit: "The description of the script goes here!") {
    depends(compile)

    def bower = classLoader.loadClass('grails.plugin.bower.BowerCommandHelper')

    event("StatusUpdate", ["Initializing bower.json"])

    if(bower.init("./grails-app/conf")) {
        event("StatusError", ["Initializing bower.json failed"])
    } else {
        event("StatusFinal", ["Successfully initialized bower.json"])
    }
}

setDefaultTarget(bowerInit)
