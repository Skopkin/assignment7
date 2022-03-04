pipeline {
    agent {
        docker {
            image "maven:3.8.4-jdk-13"
            label "docker-agent"
        }

    }


    stages {
        stage("Build") {
        	environment {
        	    HOME="."
        	}

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