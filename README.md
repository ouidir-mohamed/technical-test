# Technical Test

This is s Spring boot project that exposes 3 services:

- one that allows to register a user.
- one that displays the details of a registered user.

## Table of Contents

- [Build](#Build)
- [Run](#Run)
- [Running Tests](#Running-Tests)
- [Endpoints](#Endpoints)

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

This will start the server on the port 8080 and you should see the application output in the console.

## Running Tests

To run tests for this project, execute the following command in your terminal: `mvn test`

## Endpoints

### `POST /api/users/`

Registers a new user

#### Parameters

| Name | Type | Description
| -------- | ---------- | ------------
| userName | string | The user name. |
| countryOfResidence | String | The user's country of residence. |
| birthDate | date | The user's birth date with "YYYY-MM-DD" format . |
| phoneNumber | string | The user's phone number (Optional) . |
| gender | enum |  the user's gender MALE or FEMALE (Optional) . |

#### Request Body

``` json
{
    "userName": "mohamed01",
    "birthDate": "2004-02-09",
    "countryOfResidence": {
        "code": "FR",
        "name": "France"
    },
    "phoneNumber": "0606060606",
    "gender": "MALE"
}

```

#### Response

``` json
{
    "userName": "mohamed01",
    "birthDate": "2004-02-09",
    "countryOfResidence": "France",
    "phoneNumber": "0606060606",
    "gender": "MALE"
}

```

### `GET /api/users/{userName}/`

Returns the user with the specified userName.

#### Parameters

| Name | Type | Description |
| ---- | ---- | ----------- |
| userName | string | The userName of the user to retrieve. |

#### Response

```json

{
  "userName": "mohamed01",
  "birthDate": "2004-02-09",
  "countryOfResidence": "France",
  "phoneNumber": "0606060606",
  "gender": "MALE"
}

```