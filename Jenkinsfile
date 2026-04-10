pipeline {
    agent any
    stages {
        stage('Data Ingest & Train') {
            when { branch 'dev' }
            steps {
                echo 'Ingesting Data and Training Model...'
                sh 'python3 train.py'
                // MLflow mein model save karke 'Challenger' alias dena
                echo 'Assigning alias: Challenger'
            }
        }
        stage('Pre-prod Test') {
            when { branch 'main' }
            steps {
                script {
                    try {
                        echo 'Testing model for Pre-prod...'
                        // Yahan test script chalta hai
                        echo 'Updating alias to: Challenger-post-test'
                    } catch (Exception e) {
                        sendNotification('failed')
                    }
                }
            }
        }
    }
}
