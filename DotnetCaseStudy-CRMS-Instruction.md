# Instructions For Dotnet CRMS Case Study.  

## Introduction

The following markdown instructions has to be read by each assessment applicant and it contains the following.
   * Case Study Details.
   * Case Study Modules.
   * Prerequisites.
   * Instructions for codecommit repository , MSSQL DB , asp.Net and Angular related instructions pertaining to casestudy.
   * Rest API, Selenium and general DONT'S instructions.
	
## Case Study Details
### The casestudy is to design a web application for online booking of conference rooms. The features to be implemented are
    * Develop a web app through which employees can book conference rooms.
    * Login page must have option to login and registeration for new user. 
    * User can have two roles 
        * Facility Manager(admin).
        * Regular user.
    * Facility Manager should be able to add and remove rooms.
    * Regular user should be able to book and cancel rooms for events.
    * DashBoard Menu(After Login it should route to dashboard page)
        * Should consist Upcoming events , Cancelled events and booking history.
    * Manage Rooms Menu (Facility Manager- this menu should be only visisble and accessable to facilty managers)
        * Option to add New Room
            New Booking should ask for following details
                * Room Name.
                * Location.
                * Capacity.
                * Room Type().
                    * Conference Room.
                    * VC Room.
                * Is active(whether room is avaiable for booking).
                    * Yes
                    * No
        * Booking page should list booking details in tabular form with following details:
            * Room Name.
            * location.
            * Start Date.
            * End Date.
            * Status(Cancelled/Booked).
            * Action(Option to cancel the booking).
       
    * Booking Menu
        * Option for New Booking
            New Booking should ask for following details
                * Room Name.
                * Start Date.
                * Start Time.
                * End Date.
                * End Time.
         * Booking page should list booking details in tabular form with following details:
            * Room Name.
            * location.
            * Start Date.
            * End Date.
            * Status(Cancelled/Booked).
            * Action(Option to cancel the booking).
    * Logout option

##  Prerequisites
   * OS - Windows 10.1/ Linux
   * IDE/Tools - Visual Studio 2017,Visual Studio Code, Postman, MSSQL Server 2017, MSSQL Server Management Studio 2017 
   * Database - MSSQL
   * Node Package Manager
   * Nuget
   * IIS server 10
   * Browser [Chrome]
   * Selenium server 3.9.x

## Getting Started with AWS Code Commit 
   * The Administrator will create a AWS Code Commit Account exclusively only with your empid for the case study.
   * Instructions will be mailed with a welcome mail from administrator to every applicant detailing the AWS Code Commit Repository connection . 
   * AWS Code Commit is very similiar to GITHUB and once the CodeCommit basic security and configuration is done
   * A complete Boiler Plate code will be available , the boiler plate includes Java Framework code , MYSQL sql files , Angular Base
     Code Base, RestAssured and Selenium Lib Jars/Wars which will be used for unit testing by the applicant.
   * The applicant will have the code in the master branch of AWSCOde Commit with an unique repository created for each user apppended
     with EmpID (xxxxx).
   * Applicant can create branch from the master work on the case study in the branch , finally push the code to master and submit (More
     details are given subsequently) 
   
## Setting up Database in Mssql.
  * The name of the database should be crms_xxxxx. (Replace xxxxx with your employeeId).
  * Run the .sql and import into mssql query editor as supplied in boiler plate codecommit code codebase 
  * Create a user with username: localhost; and password: localhost .
  * Grant full rights on database crms_xxxxx to the created user.
  * Once .sql is successfully imported into new mysql schema say crms_xxxxx ,following tables will be there with needed master data . The  tables are __MigrationHistory,AspNetRoles,AspNetUserClaims,AspNetUserLogins,AspNetUserRoles,AspNetUsers,Bookings,ConfreneceRooms,RoomTypes.

## Instructions for Asp.NET application.
  * Do not delete/modify anything from webconfig.cs as this effects the evaluation.
  * Please verify  database connection string in web config is " <add name="CRMSConnection" connectionString="Data
    Source=localhost\SQLEXPRESS;Initial Catalog=CRMSDB; Integrated Security=false; user ID = *******; Password=*******;Connect
    Timeout=30" providerName="System.Data.SqlClient"/>"
  * Deploy your sln as an application to IIS server using MS deploy.
  * Follow standard sonarqube rules for codequality.
  * Application should be deployed in IIS as crms_xxxxx. (Replace xxxxx with your employeeId).
  * IIS should run on port 80
  

## Instructions for creating REST API's.
  ### The 3 REST API's should be named as per the api list.
  * /Room/GetRooms - Get Method.
  	* Status code:  200.
  * /Room/GetActiveRooms - GET Method.
  	* Status code:  200.
  * /booking/getbookings - Get Method
  	* Status code:  200.
  * Each of the RESTAPI should necessarily only in 80 IIS port and has to append mandatorily with the applicant empid(xxxxx). For eg http://localhost:80/crms_xxxxxxx/Room/GetRooms;
  
## Instructions for Angular.
  
  * All Widgets should have an id
  * Id's should be added to all the web elements as per the given Id list.This is mandatory
  * Check the images folder for the way each ids have to be defined as datadriven. The 4 funcitonality with image screenshot are Login, Registration,bookRoom and Add Room.
  
![Login Screen](/images/crms_login.png)


![Registration Screen1](/images/crms_register1.png)


![Registration Screen2](/images/crms_registration2.png)


![DashBoard Screen](/images/crms_dashboard.png)


![Booking Screen](/images/crms_bookings.png)


![Book Room Screen](/images/crms_bookRoom.png)


![Manage Room Screen](/images/crms_manageRoom.png)


![Manage Room Screen](/images/crms_addRoom.png)
  
## DON'TS   
  * Donot remove EmployeeDetails.Json file or do not modify it.
  * Donot make any changes in the Submit.sh file.
  * Make sure you pushed the code into master from branch before submitting the test.
  * Test can be submitted only once. So, do not click Submit.sh until you wish to submit finally the test. 
  * In the event of you realizing the submission has to happen again , please contact your test administrator. This is not encouraged
  * Prior to submitting by clicking submit.sh make sure both the java code and angular code is done with a clean build and complete
    checkin all the code.
  * Prior to submitting with the click of submit.sh clean the compiled code and only submit the end . 
  * If you have require any clarifications only approach the test administrator for more clarifications
  * Tests are autoevaluated it is mandatory to follow instructions so naming convention of db schema, rest api conventions, angular application parameters are all mandatory.
