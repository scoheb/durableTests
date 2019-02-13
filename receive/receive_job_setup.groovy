// update this to be unique.
def uuid = "8abcd9900-123"

pipelineJob("receive") {

    definition {
        parameters {
            stringParam('CI_MESSAGE', '', 'contents of message')
        }

        triggers {
            ciBuildTrigger {
                providerData {
                    activeMQSubscriberProviderData {
                        name("Red Hat UMB Stage")
                        overrides {
                            topic("Consumer.rh-jenkins-ci-plugin.${uuid}.VirtualTopic.eng.ci.example.durable.test")
                        }
                    }
                }
                noSquash(true)
            }
        }

        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/scoheb/durableTests.git")
                    }
                    branch("master")
                }
            }
            scriptPath("receive/Jenkinsfile")
            lightweight(true)
        }
    }
}
