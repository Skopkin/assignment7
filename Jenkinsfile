pipeline {
    agent {
        docker {
            image "maven:3.8.4-jdk-13"
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
                docker build -t todo-mjd.jar
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}