# Target-State-Role
## Shopec - This is the Java Case Study Shopping Cart Back End REST Service Application Module written in spring boot.  

## Prerequisite - Build and Setup of the application - done
* Run the Java Rest based code
* Run the Angular Front End Code and understand the application
* Check if both application is setup

## Development Job - done
1.Development Jobs contains the following in java
* Compile 
* CheckStyle
* PMD
* JUnit Coverage
* exception handling -pending
* Logging - Pending
* Shopping Cart variable - pending

2. Development Jobs for Angular - done
*  TS Lint
*  NG Build
*  Jasmine/Karma

3. build rest assured and build 
4. Build WAR

## Integration Job -done
*  Run Database Script in MYSql
*  Mysql isolation of user names for each user
*  Deploy WAR to tomcat 
*  Rest Assured deploy 
*  Selenium Test deploy
*  Runs RestAssured
*  Runs Selenium
*  Rest Assured more cases 
*  Full Maven Build with RestAssured and Selenium
* seperation of scoring evaluation , rest assured and selenium in seperate repository- Target-State-Role-Evaluation

##  Scores - Done
* Junit , PMD and CheckStyle
* Angular - Code Analysis , Jasmine, Karma
* Rest Assured and selenium scores  
* ScoringEvaluation - Ranges to be specified in JSON
* reading thru apis or xml the different scores of Static analysis, selenium and RestAssured and come up with raw scores
* Come up with weighted scores for each section and recalculate weighted scores report for the applicant

##  Port and Configuration Issues
* REST Assured - port no and API List
* Selenium- port no and API List
* Application - Mysql data source configuration
* Rights for mysql (keeping as products table alone as read only)

## Isolation and Jenkins in AWS 
* Aws IAM user and repository creation in AWS machine 
* creation of first repositories in AWS - CodeCommit with user names being distinct
* Doing the above 2 steps as scripts
* Export of Jenkins pipeline 
* Calling script which creates one repository (with unique empid) than runs the exported jenkins job
* DB script of isolation

* Jenkins pipeline to take code from two repositories  -done
* staging area where we copy war and dist and also copy from there to apache - two step process
* Jenkins Looping - done
* Jenkins run with command line parameter and also variable to pass into Jenkins and take it from say empid 
* Boiler Plate code along with employee ID JSON(ID , Name and Email) for applicants to write test

## Isolation with Git -Done(dated Sept 19)
* Isolation - creation of GIT repository and Branches with Emp ID
* Isolation -  Bash Script for creation of git clone url in respective applicant in Code Commit
* Isolation - Revised Jenkins to point to two repositories and build two branches code
* Isolation -  Export and Import of existing jenkins
* Isoation - Calling script which creates codecommit repository and also runs the jenkins pipeline (exported one)
* Isolation - Passing Jenkins with parameters and taking code
* Linux round testing

##  AWS code commit Steps -Done(Dated Sept 20)
* Create an user Applicant1 (emp id 10000) - done
* Attach Policy for the Group as AWSCODECOMMITPOWERUSER and also Attach the IAMSelfManageServiceSpecificCredentials and IAMReadOnlyAccess policies  - done
* Create a repository ShoppingCart-10000 - done
* Go to PowerUser Policy and change it to the unique ARN for that user in JSON - done
* Get the URL for the ShoppingCart-10000 repository by applicant1 - done
* Generate SSH private and Public key - done
* Isolation of MYSQL with schema and credentials - done

## Dot Net Application- CRMS
* MSBUild of solution with Jenkins Call
* Sql server isolation - with Sqlserver commands 
* Deploy into IIS with MSdeploy
* RestAPI identification and change of code and running restassured test cases
* Selenium Test identification and run of all selenium test cases after writing selenium end to end testing code
* Scoring modification for dotnet test case
* Single Run of above steps end to end in github
* Boiler Plate identification of dotnet
* Moving to CodeCommit 
* Multiple Users CodeCommit 
*
## AWS Machine EC2 Setup and Run
* Script for doing above  - Done
* Setting up Jenkins to run in AWS EC2
* Calling the pipeline for two users after checkin happens 
* Boiler plate code for each user .

## Long term issues in next 2 weeks from 08/27 to 09/30
* Isolation of Git for multiple users
* Static Analysis Rules to be configured preferably google based Rules
* MD instructions for the applicant
* Tomcat should be use shared or local
* Base Package for testing with the right boiler plate code for one sample java case study shopping cart
* Selenium Granularity of Scores
* jenkins parameters calling
* One DotNEt case study Build
* Rest Assured and Selenium - Applicant writing portion of it
* Selenium Break up of test case - granular score
* Different forms of Rest Assured testing
* hibernate token generation header
* Rest Assured  REST API more test cases - evaluation vs applicants.
* Security Of Rest API
* Multiple CaSe studies and Multiple Users
* Maven can the user change

## Isolation Meeting with KK on Sept 03,2018
* AWS Code Commmit - Repository creation is for each user .- Done
* Administrator will create in AWS code commit - Will have for every applicant each Respository,and each isolated  Schema, Private and public key creation.- Done
* Administrator will also create boilerplate code for each case study. - Done

