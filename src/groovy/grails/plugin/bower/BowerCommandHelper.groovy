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
package grails.plugin.bower

/**
 * The <code>BowerCommandHelper</code> is a utility class for dealing
 * with Bower's CLI.
 */
class BowerCommandHelper {

    static final String DEFAULT_CONFIGURATION_DIRECTORY = "./grails-app/conf"

    /**
     * Initialize bower.json file with information requested on the
     * command line.
     * @return Exit code
     */
    static init(directory) {
        return runBowerCommand(directory, "init", "--config.interactive")
    }

    /**
     * Install Bower dependencies into the specified directory.
     * @param directory Directory to store dependencies in
     * @return Exit code
     */
    static install(directory) {
        return runBowerCommand(directory, "install")
    }

    /**
     * Run a Bower command with arguments
     * @param directory The command's working directory
     * @param command The command
     * @param args The list of arguments
     * @return Exit code
     */
    static runBowerCommand(String directory, command, String... args) {
        def processArgs = ["bower", command]
        args.each { processArgs << it }

        def processBuilder = new ProcessBuilder(processArgs)
        processBuilder.directory(new File(directory))
        processBuilder.inheritIO()

        def proc = processBuilder.start()

        proc.waitFor()

        return proc.exitValue()
    }
}
