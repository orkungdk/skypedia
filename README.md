# Skypedia

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample application.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

- Application will be run on 8081 port. 
- Application context path is skypedia.
- You may access the application with following url: http://localhost:8081/skypedia
- H2 database console can be reached with following url: http://localhost:8081/skypedia/h2

## Build application

```
mvn clean install -DskipTests
```

First of all, application needs to be built to be able to generate auto generated classes. For instance, mappers. The reason is that, mapper classes that are annotation with
```
@Mapper
public abstract SkypediaMapper {
    ...
```  
does not have any implementation inside. Instead, mapstruct automatically maps between parameters and returns type according to field names with auto generated classes that are created on the build time.

## Testing
In the **postman** folder, you may find Postman collections and environment variables. 
https://learning.postman.com/docs/getting-started/importing-and-exporting-data/

Test steps need to be follow exactly the same order in postman collection.

1. Add an airline company
2. Add a location
3. Add a airport
4. Add a route
5. Add a flight
6. Add a ticket / Bulk insert tickets
7. Book a ticket