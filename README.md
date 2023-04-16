# SpringBootLatest
# Spring Boot 3, JDK 17, latest swagger

# Prerequisite   
Spring web  
Spring h2db  
Spring JPA  
Spring devtool  
Spring swagger  
Logging monitoring  


# MiniProject-1 Insurance:
1. Get all Plan categories
2. Create plan policy
3. View all policies
4. Enable/Disable policies
5. Hard delete policy

# First analysis prepopulated data: analyse no of tables, fields, Entities, Repositories, Services, Controllers

# DB URL: localhost:8080/h2-console
# Swagger URL: http://localhost:8080/swagger-ui/index.html


#################
01-Mini Project
##################

-> Develop one microservice to manage insurance plans of our project

-> Microservice should have below functionalities


1) Create Plan

2) View Plans

3) Edit & Update Plan

4) Activate & De-Activate

5) Delete Plan (Hard Delete)


Key-Points: 

Tech Stack : Spring Boot, REST API, Data JPA & H2 DB

-> Use Embedded Database (h2) For Storage
-> Provide Swagger Documentation
-> Push Code into Git Hub Repo
-> Deploy Project into AWS Cloud Using JENKINS CI CD


##############
Database Table
##############

Table-1 : PLAN_CATEGORY

CATEGORY_ID   			NUMBER		PRIMARY KEY
CATEGORY_NAME		VARCHAR
ACTIVE_SW				CHAR
CREATE_DATE			DATE
UPDATE_DATE			DATE
CREATED_BY			VARCHAR
UPDATED_BY			VARCHAR


Table-2 :  PLAN_MASTER

PLAN_ID						NUMBER			PRIMARY KEY
PLAN_NAME					VARCHAR
PLAN_START_DATE			DATE			
PLAN_END_DATE				DATE
PLAN_CATEGORY_ID			NUMBER
ACTIVE_SW					CHAR
CREATE_DATE				DATE
UPDATE_DATE				DATE
CREATED_BY				VARCHAR
UPDATED_BY				VARCHAR




Entity Classes
------------------------
PlanCategory.java
Plan.java


Dao Layer / Repository Layer
---------------------------------------
PlanCategoryRepo.java 
PlanRepo.java


Service Layer
--------------------
PlanService.java (I)
PlanServiceImpl.java (C)

WebLayer
--------------
PlanRestController.java


Config
----------
SwaggerConfig.java


#################
Project Setup  
################


Step-1) Create Spring Boot Application with below depenencies  
  
		a)  starter-web  
		b)  starter-data-jpa  
		c)  h2   
		d) devtools  
		c) swagger   
		d) swagger-ui  
		e) project lombok  
  
  
			<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.1.0</version>
		</dependency>
  
  
Step-2) Configure DataSource Properties in application.properties file  

# Data Source Properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=ashokit
spring.datasource.password=ashokit
spring.datasource.driver-class-name=org.h2.Driver

# ORM Properties
spring.jpa.hibernate.ddl-auto= update
Note: For DB testing purpose run the application and access h2-console using below URL

		URL : http://localhost:port/h2-console
Step-3) Create Entity classes with Database tables mapping    
Step-4 ) Create Repository Interfaces  
Note: Run the application and verify database (Tables should be created)  
Step-5) Create Service interface with Implementation  (business logic)  
Step-6) Create Rest Controller with Required methods (Request Handlers)  
Step-7) Create Swagger Config class to generate documentation  
Step-8) Run the application and test it using Swagger-UI  

		
		http://localhost:8080/swagger-ui.html


---------------------------------------------------------------------

-> When we create boot application we are getting application.properties file by default  
  
-> application.properties file will represent data in key-value format  
  
	Ex:    
  
		server.port = 8080  

-> properties file will be used only in java


-> YML stands for YET Another Markup Language

-> YML format is universal to represent data / configuration  
  
->  YML can represent data in key-value, list and map also  
  
-> YML format supported by several programming languages  
  
-> Instead of application.properties we can use application.yml file in Spring Boot  
  
-> In YML file indent spaces are very important  
  
  
++++++++++++++++++++++
Reading Data From YML  
+++++++++++++++++++++
  
  
------------------------application.yml----------------------------
spring:  
  datasource:  
    driver-class-name: org.h2.Driver  
    password: ashokit  
    url: jdbc:h2:mem:testdb  
    username: ashokit  
  jpa:  
    hibernate:  
      ddl-auto: update  
plan-api:  
  messages:  
    planSaveSucc: Plan Saved Successfully  
    planSaveFail: Plan Save Failed  
    planUpdateSucc: Plan Updated Successfully  
    planUpdateFail: Plan Update Failed  
    planDeleteSucc: Plan Deleted Successfully  
    planDeleteFail: Plan Delete Failed  
    planStatusChange: Plan Status Changed Successfully  
    planStatusChangeFail: Plan Status Change Failed  
  
----------------------------------AppProperties.java-------------------------------------  
@Data  
@EnableConfigurationProperties  
@ConfigurationProperties(prefix = "plan-api")  
@Configuration  
public class AppProperties {  
  
	private Map<String, String> messages = new HashMap<>();  
  
}  
  
--------------------------------PlanRestController.java--------------------------------  
  
@RestController  
public class PlanRestController {  
  
	private PlanService planService;  
	  
	private Map<String, String> messages;  
	  
	public PlanRestController(PlanService planService, AppProperties appProps) {  
		this.planService = planService;  
		this.messages = appProps.getMessages();  
		System.out.println(this.messages);  
	}  
  
	//methods of our rest controller  
}  
  
-----------------------------------------------------------------------------------------------------
  
  
-> We should remove String literals and we should configure them in AppConstants class  
  
  
public class AppConstants {  
  
	public static final String EMPTY_STR = "";  
  
	public static final String PLAN_SAVE_SUCC = "planSaveSucc";  
  
	public static final String PLAN_SAVE_FAIL = "planSaveFail";  
	  
	public static final String PLAN_UPDATE_SUCC = "planUpdateSucc";  
	  
	public static final String PLAN_UPDATE_FAIL  = "planUpdateFail";  
	  
	public static final String PLAN_DELETE_SUCC = "planDeleteSucc";  
	  
	public static final String PLAN_DELETE_FAIL = "planDeleteFail";  
	  
	public static final String PLAN_STATUS_CHANGE = "planStatusChange";  
	  
	public static final String PLAN_STATUS_CHANGE_FAIL = "planStatusChangeFail";  
}  

-----------------------------------------------------------------------------------------------------------------------------------------------------------












