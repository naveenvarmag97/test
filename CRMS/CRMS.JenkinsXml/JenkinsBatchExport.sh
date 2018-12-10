java -jar jenkins-cli.jar -s http://localhost:7070 get-job javaangularcasestudy-dev  > javaangularcasestudy-dev.xml
java -jar jenkins-cli.jar -s http://localhost:7070 get-job ngangularcasestudy-dev  > ngangularcasestudy-dev.xml
java -jar jenkins-cli.jar -s http://localhost:7070 get-job restassured-deploy  > restassured-deploy.xml
java -jar jenkins-cli.jar -s http://localhost:7070 get-job selenium-deploy  > selenium-deploy.xml
java -jar jenkins-cli.jar -s http://localhost:7070 get-job scoreevaluation-dev  > scoreevaluation-dev.xml


java -jar jenkins-cli.jar -s http://localhost:7070 get-view javaangularcasestudy-buildpipeline > javaangularcasestudy-buildpipeline.xml

