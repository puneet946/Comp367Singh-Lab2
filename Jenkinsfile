pipeline {
    agent any
      environment {
        DOCKER_HUB_PWD = credentials('DockerhubID')
        DOCKER_IMAGE_NAME = 'psing946/mavenapp'
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven3"
     
    }
    

    stages {
         stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/puneet946/Comp367Singh-Lab2.git'
            }
        }
        stage('Build') {
            steps {
               

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            

           
        }
        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImage = docker.build(DOCKER_IMAGE_NAME)
                }
            }
        }

        stage('Docker Login') {
            steps {
                script {
                    sh "docker login -u psing946 -p ${DOCKER_HUB_PWD}"
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    sh "docker push ${DOCKER_IMAGE_NAME}"
                }
            }
        }
    }
}
