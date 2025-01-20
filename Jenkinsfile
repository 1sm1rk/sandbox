pipeline {
    agent any
    environment {
        GITHUB_TOKEN=credentials('github_push_token')
    }
    stages {
        /*stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }*/
        stage('Docker Build') {
           agent any
           steps {
               sh 'docker build -t 1sm1rk/sandbox:0.0.1 .'
           }
       }
        stage('login to GHCR') {
            steps {
                sh 'echo $GITHUB_TOKEN_PSW | docker login ghrc.io -u $GITHUB_TOKEN_USR --passwrd-stdin'
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}
