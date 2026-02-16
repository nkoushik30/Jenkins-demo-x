pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building for Windows...'
            }
        }

        stage('Test') {
            steps { 
                bat 'javac HelloWorld.java'
                bat 'java HelloWorld'
            }
        }

        stage('Output') {
            steps {
                echo 'Archiving Windows Artifacts...'
                archiveArtifacts artifacts: 'output/*.txt', fingerprint: true
            }
        }
    }
}
