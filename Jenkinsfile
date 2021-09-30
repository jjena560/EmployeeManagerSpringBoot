pipeline{
	agent any
	environment {
       		env.PATH = env.PATH + ";c:\\Windows\\System32"
   	}
	tools{
		maven 'Maven'
		jdk 'jdk-11'
		}
		
	
		 
	stages {
		stage ("initialize") {
			steps {
			bat 'mvn clean install'
			}
		
		}
	}   
        
}
