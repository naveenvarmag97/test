java -jar jenkins-cli.jar -s http://localhost:7070 create-job javaangularcasestudy-dev  < javaangularcasestudy-dev.xml
java -jar jenkins-cli.jar -s http://localhost:7070 create-job ngangularcasestudy-dev  < ngangularcasestudy-dev.xml
java -jar jenkins-cli.jar -s http://localhost:7070 create-job restassured-deploy  < restassured-deploy.xml
java -jar jenkins-cli.jar -s http://localhost:7070 create-job selenium-deploy  < selenium-deploy.xml
java -jar jenkins-cli.jar -s http://localhost:7070 create-job scoreevaluation-dev  < scoreevaluation-dev.xml

java -jar jenkins-cli.jar -s http://localhost:7070 create-view javaangularcasestudy-buildpipeline  < javaangularcasestudy-buildpipeline.xml

java -jar jenkins-cli.jar -s http://localhost:7070  build javaangularcasestudy-dev 