pipeline {
	environment {
		JAVA_TOOL_OPTOPNS: "-Duser.home=/var/maven"
	}
    agent {
    	docker {
    		image "maven:3.8.4-jdk-13"
    		label "docker"
    		args "-v /tmp/maven:/var/maven/.m2 -e MAVEN_CONFIG=/var/maven/.m2"
    	}
    }

    stages {
        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean install"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}