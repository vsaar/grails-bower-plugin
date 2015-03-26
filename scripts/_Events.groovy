// install Bower dependencies
eventPackagingEnd = {
    includeTargets << grailsScript("_GrailsEvents")

    def bower = classLoader.loadClass('grails.plugin.bower.BowerCommandHelper')

    event("StatusUpdate", ["Installing Bower dependencies"])

    if(bower.install(config.grails.plugin.bower.configurationDirectory ?: bower.DEFAULT_CONFIGURATION_DIRECTORY)) {
        event("StatusError", ["Installing Bower dependencies failed"])
    } else {
        event("StatusFinal", ["Bower dependencies installed successfully"])
    }
}
