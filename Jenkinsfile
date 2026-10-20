pipeline {
    agent any

    environment {
        PATH = "/opt/homebrew/bin:/opt/homebrew/opt/openjdk@21/bin:${env.PATH}"
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        
        stage('Inspect Target') {
            steps {
                echo 'Содержимое каталога target после сборки:'
                sh 'ls -la target'
            }
        }
    }
}
