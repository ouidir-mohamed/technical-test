# Technical Test

This is s Spring boot project that exposes 3 services:
- one that allows to register a user.
- one that displays the details of a registered user.
- one that displays all countries with their codes.

## Build

To build this project from source, you will need to have the following installed on your machine:

- Java 8 or later
- Maven

Once you have the prerequisites installed, follow these steps to build the project:

1. Clone the repository to your local machine: `https://github.com/ouidir-mohamed/technical-test`
2. Navigate to the root directory of the project: `cd technical-test`
3. Build the project using Maven: `mvn package`

This will build the project and create a WAR file in the `target` directory.

## Run

To run the application, follow these steps:

1. Navigate to the `target` directory: `cd target`
2. Run the WAR file: `java -jar technicaltest-0.0.1-SNAPSHOT.war`

This will start the Spring Boot application and you should see the application output in the console.
