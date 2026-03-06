pipeline {
    agent any

    environment {
        DOCKER_HUB_USER = 'adithya952'
        APP_NAME = 'scientific-calculator'
        IMAGE_TAG = "${env.BUILD_ID}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Compiles the code and builds the JAR, but skips running the tests
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Runs the JUnit tests
                sh 'mvn test'
            }
            post {
                success {
                    // Only archives the JAR if the tests pass successfully
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Containerize & Push') {
            steps {
                script {
                    // Builds the image using your Java 27 Dockerfile
                    def app = docker.build("${DOCKER_HUB_USER}/${APP_NAME}:${IMAGE_TAG}")

                    // Authenticates and pushes to Docker Hub
                    docker.withRegistry('', 'dockerhub-credentials') {
                        app.push()
                        app.push("latest")
                    }
                }
            }
        }

        stage('Trigger Deployment') {
            steps {
                // Uses your inventory.ini file for Ansible deployment
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }
    }

    post {
        success {
            mail to: 'adithyaudayan952@gmail.com',
                 subject: "SUCCESS: Pipeline ${currentBuild.fullDisplayName}",
                 body: "Good news! The Scientific Calculator build and local deployment passed successfully.\n\nYou can view the build logs here: ${env.BUILD_URL}"
        }
        failure {
            mail to: 'adithyaudayan952@gmail.com',
                 subject: "FAILED: Pipeline ${currentBuild.fullDisplayName}",
                 body: "Oops! The Scientific Calculator pipeline failed.\n\nPlease check the Jenkins console output to see which stage caused the error: ${env.BUILD_URL}"
        }
    }
}