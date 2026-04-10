@Library('my-shared-library') _ 
pipeline {
    agent any
    
    environment {
        MLFLOW_TRACKING_URI = "http://localhost:5000"
    }

    stages {
        // 1. Development Stage (Dev Branch)
        stage('Data Ingest & Train') {
            when { branch 'dev' }
            steps {
                echo 'Ingesting Data and Training Model...'
                sh 'python3 train.py'
                echo 'Model Trained and Registered as Challenger.'
            }
        }

        // 2. Pre-production Stage (Main Branch)
        stage('Pre-prod Test') {
            when { branch 'main' }
            steps {
                script {
                    try {
                        echo 'Testing model for Pre-prod...'
                        sh "python3 -c \"import mlflow; from mlflow import MlflowClient; client = MlflowClient(); client.set_registered_model_alias('iris_model', 'Challenger-post-test', '1')\""
                        echo 'Alias updated to: Challenger-post-test'
                        sendNotification('success') 
                    } catch (Exception e) {
                        sendNotification('failed')
                        error "Pipeline failed during Pre-prod Test"
                    }
                }
            }
        }

        // 3. Production Stage (Git Tags - v1.0, v1.1, etc.)
        stage('Production Release') {
            when { buildingTag() } // Ye line Tags ko pakray gi
            steps {
                script {
                    try {
                        echo 'Promoting Model to Champion...'
                        sh "python3 -c \"import mlflow; from mlflow import MlflowClient; client = MlflowClient(); client.set_registered_model_alias('iris_model', 'Champion', '1')\""
                        echo 'Alias updated to: Champion'
                        sendNotification('success')
                    } catch (Exception e) {
                        sendNotification('failed')
                        error "Promotion to Champion failed"
                    }
                }
            }
        }
    }
}