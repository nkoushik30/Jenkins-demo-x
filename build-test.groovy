pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building for Windows...'
                bat 'if not exist output mkdir output'
                bat 'echo This is the Windows build binary > output\\app-bin.txt'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Windows Tests...'
                bat 'echo Testing logic goes here...'
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
