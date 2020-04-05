pipeline {
   agent any


   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/prity0642/FootballLeague.git'

            // Run Maven on a Unix agent.
            //sh "mvn -Dmaven.test.failure.ignore=true clean package"

            // To run Maven on a Windows agent, use
             bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }
        
      }
       stage('Deploy'){
          steps{
            bat label: '', script: 'C:\\Users\\prati\\Downloads\\kubectl.exe apply -f deployment.yaml'
          }
         }
   }
}
