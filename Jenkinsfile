pipeline {
    agent any

    stages {
        stage('Checkout the repo') {
            steps {
                echo 'Checkout of expense tracker repo'
                git 'https://github.com/vigneshtraining/expense.git'
            }
        }
        stage('Compiling the expense tracker') {
            steps {
                echo 'Compiling the expense tracker'
                sh '/usr/bin/mvn compile'
            }
        }
        stage('Test the expense tracker') {
            steps {
                echo 'Test the expense tracker'
                sh '/usr/bin/mvn test'
            }
        }
        stage('Packaging the expense tracker') {
            steps {
                echo 'Packaging the expense tracker'
                sh '/usr/bin/mvn clean install'
            }
        }
        stage('Deployment') {
            steps {
                echo 'Deploying the expense tracker'
                sh 'systemctl start expense &'
            }
        }
    }
}
