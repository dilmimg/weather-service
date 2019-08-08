# Weather Service
A simple weather service application

## Prerequisites
* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 8 or higher
* [NodeJS](https://nodejs.org/en/) 10 or higher
* NPM

## API
Spring Boot API bootstrapped by [Spring Initializr](https://start.spring.io/)

Inside the api directory, you can run:

`mvn clean install`
to generate the .war file which can be deployed in Apache Tomcat. Open http://localhost:8080 to view it in the browser.

*Tip* CORS is enabled in the client using webpack proxy in order for the client to communicate with the API.
'target' url in proxy.conf.json file in the angular client can be modified if you want to change the default api url.


## Client
Angular frontend client.

Inside the client directory, you can run some built-in commands:

`npm start`
to run the app in development mode. Open http://localhost:4200 to view it in the browser.

The page will automatically reload if you make changes to the code. You will see the build errors and lint warnings in the console.
