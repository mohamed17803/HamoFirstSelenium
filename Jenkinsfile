pipeline {
    agent any

    triggers {
        cron('H */12 * * *')
    }

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    options {
        timeout(time: 15, unit: 'MINUTES')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/mohamed17803/HamoFirstSelenium.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test -Dsurefire.suiteXmlFiles=testNG.xml'
            }
        }

        stage('Allure Report') {
            steps {
                allure(
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                )
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.xml', fingerprint: true
        }
        success {
            echo 'Regression Suite Passed Successfully.'
        }
        failure {
            echo 'Regression Suite Failed.'
        }
    }
}
