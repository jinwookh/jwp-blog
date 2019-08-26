pipeline {
  agent any
  stages {
    stage('hello') {
      parallel {
        stage('hello') {
          steps {
            sh 'echo \'hello!\''
          }
        }
        stage('build') {
          steps {
            sh './gradlew clean build'
          }
        }
      }
    }
  }
}