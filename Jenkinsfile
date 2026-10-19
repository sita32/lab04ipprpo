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

        // Этап из ЛР №3. Индивидуальное задание ЛР №4 — сценарий acceptCar
        // и тест acceptCarMovesNewOrderToInProgress, он выполняется на этапе Test.
        stage('Inspect Target') {
            steps {
                echo 'Содержимое каталога target после сборки:'
                sh 'ls -la target'
            }
        }
    }
}
