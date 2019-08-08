# Weather Service
A simple weather service application

## Prerequisites
* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 8 or higher
* [NodeJS](https://nodejs.org/en/) 10 or higher
* NPM

## API
Spring Boot API bootstrapped by [Spring Initializr](https://start.spring.io/)

Inside the api directory, you can run some built-in commands:

`./gradlew bootRun or gradlew.bat bootRun`
Runs the api locally. Open http://localhost:8080 to view it in the browser.

*Tip* you will need to enable CORS in order for your Client to communicate with the API
[Spring Rest CORS](https://spring.io/guides/gs/rest-service-cors/)


## Client
Angular frontend client.

Inside the client directory, you can run some built-in commands:

`npm start`
Runs the app in development mode. Open http://localhost:4200/to view it in the browser.

The page will automatically reload if you make changes to the code. You will see the build errors and lint warnings in the console.
