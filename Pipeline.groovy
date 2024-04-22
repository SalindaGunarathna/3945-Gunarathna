pipeline {
    agent any
    stages {
        stage ('SCM checkout'){
            steps{
                retry(3){
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/SalindaGunarathna/3945-Gunarathna']])
                }
            }
      
        }
        stage('build docker'){
            steps {
                sh 'docker build -t salindadocker/docker-image .'
            }
        
        }
         stage('run'){
            steps{
                sh 'docker run -d -p 5000:3000 salindadocker/docker-image'
         }
         }
         stage('show runing containers'){
      steps{
        sh 'docker ps'
      }
    }
    }
}