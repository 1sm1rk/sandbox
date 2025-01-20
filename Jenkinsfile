pipeline {
    agent any
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
    }
}
