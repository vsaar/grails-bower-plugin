// install Bower dependencies
eventPackagingEnd = {
    includeTargets << grailsScript("_GrailsEvents")

    def bower = classLoader.loadClass('grails.plugin.bower.BowerCommandHelper')

    event("StatusUpdate", ["Installing Bower dependencies"])

    if(bower.install("../assets/external")) {
        event("StatusError", ["Installing Bower dependencies failed"])
    } else {
        event("StatusFinal", ["Bower dependencies installed successfully"])
    }
}
