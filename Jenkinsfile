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
                // Pulls code from the GitHub repository
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Runs Maven to compile and execute JUnit tests
                sh 'mvn clean package'
            }
            post {
                success {
                    // Archive the generated JAR file
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Containerize & Push') {
            steps {
                script {
                    // Builds the Docker image using your Dockerfile
                    def app = docker.build("${DOCKER_HUB_USER}/${APP_NAME}:${IMAGE_TAG}")

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
                sh 'ansible-playbook -i localhost, deploy.yml'
            }
        }
    } // <--- 'stages' block ends here!

    // The global 'post' block goes HERE, outside of 'stages' but inside 'pipeline'
    post {
        success {
            mail to: 'adithyaudayan952@gmail.com',
                 subject: "✅ SUCCESS: Pipeline ${currentBuild.fullDisplayName}",
                 body: "Good news! The Scientific Calculator build and local deployment passed successfully.\n\nYou can view the build logs here: ${env.BUILD_URL}"
        }
        failure {
            mail to: 'adithyaudayan952@gmail.com',
                 subject: "❌ FAILED: Pipeline ${currentBuild.fullDisplayName}",
                 body: "Oops! The Scientific Calculator pipeline failed.\n\nPlease check the Jenkins console output to see which stage caused the error: ${env.BUILD_URL}"
        }
    }
}