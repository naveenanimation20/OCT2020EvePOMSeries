pipeline{
   agent any
   
   stages{
       
       stage("Build"){
           steps{
            echo("Building")
           }
       }
       
        stage("Deploy DEV"){
            steps{
           echo("Dev deployment")
            }
       }
       
       stage("Deploy QA"){
           steps{
           echo("QA deployment")
           }
       }
       
       stage("Regression Test"){
           steps{
           echo("run test automation")
           }
       }
       
       stage("Deploy Stage"){
           steps{
            echo("Stage deployment")
           }
       }
       
       stage("Sanity Test"){
           steps{
           echo("sanity test on stage")
           }
       }
       
       stage("Deploy PROD"){
           steps{
           echo("PROD deployment")
           }
       }
       
   }
   
    
}