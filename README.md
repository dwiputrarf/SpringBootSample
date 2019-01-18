# POS For A Store Project
This is a RESTFUL API project using Springboot technology with following method for simple CRUD purposes :
1. JPA Repository
2. MySQL Database
3. Hibernate
4. Custom JSON ResponseEntity

## Make your first project
1. File **>** New **>** Maven Project.
2. **Select project name and location Dialog >** Let it be default.
3. **Select an Archetype >** choose maven-archetype-webapp.
4. **Enter Artifact id >**  enter your group id for the `package path` and enter your artifact id for your `app name`.
5. Click finish and wait the maven update.
 
 ## Setting your POM.XML Dependencies
 1. Add parent after `url tag`
 ```
  <parent>
  	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
 	<version>1.5.4.RELEASE</version>
  	<relativePath/>
  </parent>
  ```
 2. Add the dependency in `dependecies tag`
  ```
  <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-devtools</artifactId>
    	<scope>runtime</scope>
    </dependency>
    <dependency>
    	<groupId>mysql</groupId>
    	<artifactId>mysql-connector-java</artifactId>
    	<scope>runtime</scope>
    </dependency>
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-test</artifactId>
    	<scope>test</scope>
    </dependency>
  ```
