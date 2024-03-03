pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build Maven') {
            steps {
                // Get some code from a GitHub repository
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/pnkj95/devops-integration.git']])

                // Run Maven on a Unix agent.
                sh "mvn clean install"

            
            }

        }
        stage('Build Docker Image') {
            steps {
                script{
                    sh "docker build -t debugdynamo/devops-integration ."
                }

              
            }

        }
        stage('Push Docker Image To Hub') {
            steps {
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        
                        sh "docker login -u debugdynamo -p ${dockerhubpwd}"
                        
                        sh "docker push debugdynamo/devops-integration"
                    } 
                }

              
            }

        }
    }
}
