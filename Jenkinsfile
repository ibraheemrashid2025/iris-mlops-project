pipeline {
    agent any
    
    // Environment variables taake MLflow ko rasta milay
    environment {
        MLFLOW_TRACKING_URI = "http://localhost:5000"
    }

    stages {
        stage('Data Ingest & Train') {
            when { branch 'dev' }
            steps {
                echo 'Ingesting Data and Training Model...'
                // train.py model ko register aur 'Challenger' alias deta hai
                sh 'python3 train.py'
                echo 'Model Trained and Registered as Challenger.'
            }
        }

        stage('Pre-prod Test') {
            when { branch 'main' }
            steps {
                script {
                    try {
                        echo 'Testing model for Pre-prod...'
                        // Yahan hum MLflow Client use karke alias update kar rahay hain
                        sh """
                        python3 -c "import mlflow; from mlflow import MlflowClient; \
                        client = MlflowClient(); \
                        client.set_registered_model_alias('iris_model', 'Challenger-post-test', '1')"
                        """
                        echo 'Alias updated to: Challenger-post-test'
                        
                        // Success notification from your Shared Library
                        sendNotification('success') 
                    } catch (Exception e) {
                        // Failure notification from your Shared Library
                        sendNotification('failed')
                        error "Pipeline failed during Pre-prod Test"
                    }
                }
            }
        }
    }
}