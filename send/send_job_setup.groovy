pipelineJob("send") {

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/scoheb/durableTests.git")
                    }
                    branch("master")
                }
            }
            scriptPath("send/Jenkinsfile")
            lightweight(true)
        }
    }
    
}
