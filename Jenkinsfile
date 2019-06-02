pipeline {
  agent {
    docker {
      image 'openjdk:11-jdk'
    }

  }
  stages {
    stage('build') {
      steps {
        sh './gradlew build'
      }
    }
  }
  post {
    always {
      junit 'build/reports/**/*.xml'
    }
  }
}