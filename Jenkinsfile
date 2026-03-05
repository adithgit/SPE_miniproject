pipeline {
    agent any

    environment {
        // Replace with your Docker Hub username
        DOCKER_HUB_USER = 'adithya952'
        APP_NAME = 'scientific-calculator'
        IMAGE_TAG = "${env.BUILD_ID}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulls code from the GitHub repository [cite: 12]
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Runs Maven to compile and execute JUnit tests [cite: 12]
                sh 'mvn clean package'
            }
            post {
                success {
                    // Archive the generated JAR file
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Containerize') {
            steps {
                script {
                    // Builds the Docker image using your Dockerfile [cite: 15]
                    app = docker.build("${DOCKER_HUB_USER}/${APP_NAME}:${IMAGE_TAG}")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    // Uses the credential ID created in Jenkins settings
                    docker.withRegistry('', 'dockerhub-credentials') {
                        app.push()
                        app.push("latest")
                    }
                }
            }
        }

        stage('Trigger Deployment') {
            steps {
                // This stage will later call your Ansible playbook [cite: 17, 18]
                echo 'Ready for Ansible Deployment'
            }
        }
    }
}