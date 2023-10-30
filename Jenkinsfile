pipeline {
    agent any

    stages {
        stage('Build with Maven') {
            steps {
                  bat 'mvn clean install'
            }
        }
    }
}
