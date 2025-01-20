pipeline {
    agent any
    environment {
        GITHUB_TOKEN=credentials('github_push_token')
        IMAGE_NAME='1sm1rk/sandbox'
        IMAGE_VERSION='0.0.1'
    }
    stages {
       stage('Docker Build') {
           agent any
           steps {
               sh 'docker build -t $IMAGE_NAME:$IMAGE_VERSION .'
           }
       }
        stage('login to GHCR') {
            steps {
                sh 'echo $GITHUB_TOKEN_PSW | docker login ghrc.io -u $GITHUB_TOKEN_USR --password-stdin'
            }
        }
        stage('tag image for github') {
            sh 'docker tag $IMAGE_NAME:$IMAGE_VERSION ghcr.io/$IMAGE_NAME:$IMAGE_VERSION'
        }
        stage('push image to github') {
            sh 'docker push ghcr.io/$IMAGE_NAME:$IMAGE_VERSION'
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}
