/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import grails.plugin.bower.BowerCommandHelper

class BowerGrailsPlugin {
    def version = "0.1.0-SNAPSHOT"
    def grailsVersion = "2.3 > *"
    def title = "Bower Plugin"
    def author = "Victor Saar"
    def authorEmail = "work@victor-saar.de"
    def description = '''The Grails Bower plugin automatically installs Bower dependencies whenever bower.json changes.'''
    def documentation = "https://github.com/vsaar/grails-bower-plugin"
    def license = "APACHE"
    def issueManagement = [system: "GITHUB", url: "https://github.com/vsaar/grails-bower-plugin/issues"]
    def scm = [url: "https://github.com/vsaar/grails-bower-plugin"]

    def pluginExcludes = [
        "grails-app/assets/**",
        "grails-app/conf/bower.json"
    ]
    def watchedResources = "file:./grails-app/conf/bower.json"

    def onChange = { event ->
        log.info "Installing Bower dependencies"

        if(BowerCommandHelper.install("../assets/external")) {
            log.error "Installing Bower dependencies failed"
        } else {
            log.info "Bower dependencies installed successfully"
        }
    }
}
