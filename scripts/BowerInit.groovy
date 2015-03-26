includeTargets << grailsScript("_GrailsPackage")

// initialize bower.json
target(bowerInit: "The description of the script goes here!") {
    depends(compile, createConfig)

    def bower = classLoader.loadClass('grails.plugin.bower.BowerCommandHelper')

    event("StatusUpdate", ["Initializing bower.json"])

    if(bower.init(config.grails.plugin.bower.configurationDirectory ?: bower.DEFAULT_CONFIGURATION_DIRECTORY)) {
        event("StatusError", ["Initializing bower.json failed"])
    } else {
        event("StatusFinal", ["Successfully initialized bower.json"])
    }
}

setDefaultTarget(bowerInit)
