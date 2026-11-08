# Airline Management API

## Project Overview

This project is a REST API developed using Java and Spring Boot. The application manages
airline-related information, including cities, airports, aircraft, and passengers.

The application connects to a PostgreSQL database and uses Spring Data JPA and Hibernate to
manage data. REST API endpoints allow users to retrieve, create, update, and delete information.

Postman is used to test the endpoints and verify that the application communicates with the
database correctly.

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- IntelliJ IDEA
- Postman
- Git and GitHub

## Project Structure

The project is organized into separate packages for each entity.

```text
src/main/java/com/keyin/airlineapi/
├── AirlineapiApplication.java
├── city/
│ ├── City.java
│ ├── CityController.java
│ └── CityRepository.java
├── airport/
│ ├── Airport.java
│ ├── AirportController.java
│ └── AirportRepository.java
├── aircraft/
│ ├── Aircraft.java
│ └── AircraftRepository.java
└── passenger/
├── Passenger.java
└── PassengerRepository.java
```

The entity classes represent database tables, repositories handle database operations, and
controllers handle API requests.

Additional controllers will be included as the remaining features are completed.

## Database Entities

### City

The City entity stores information about cities.

- id
- name
- state
- population
- airports

### Airport

The Airport entity stores information about airports.

- id
- name
- code
- city
- aircraft

### Aircraft

The Aircraft entity stores information about aircraft.

- id
- type

- airlineName
- numberOfPassengers
- passengers
- airports

### Passenger

The Passenger entity stores passenger information.

- id
- firstName
- lastName
- phoneNumber
- city
- aircraft

## Database Relationships

### One-to-Many: City and Airport

One city can have multiple airports, while each airport belongs to one city.

### Many-to-Many: Airport and Aircraft

An airport can have multiple aircraft, and an aircraft can be associated with multiple airports.

### Many-to-Many: Passenger and Aircraft

A passenger can be associated with multiple aircraft, and an aircraft can have multiple
passengers.

JPA annotations are used to define these relationships. Jackson annotations are also used to
prevent circular references when returning JSON data.

## Repositories

Each entity has a repository interface that extends `JpaRepository`.

Spring Data JPA provides built-in database operations, including:

- `findAll()` - Retrieves all records.
- `findById()` - Finds a record using its ID.
- `save()` - Creates or updates a record.
- `deleteById()` - Deletes a record using its ID.

These methods allow the application to interact with PostgreSQL without writing SQL queries
for basic CRUD operations.

## API Endpoints

The application uses REST endpoints to manage information.

### Confirmed GET Endpoints

| Method | Endpoint | Description |

|---|---|---|
| GET | `/cities` | Retrieves all cities |
| GET | `/airports` | Retrieves all airports |

### Additional CRUD Operations

The application is designed to support:

- GET - Retrieve records.
- POST - Create new records.
- PUT - Update existing records.
- DELETE - Remove records.

Additional endpoint paths will be documented after the remaining controllers are completed and
tested.

## Database Configuration

The application uses PostgreSQL.

Database settings are configured in `src/main/resources/application.properties`.

Example configuration:

```properties
spring.application.name=airlineapi
spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:postgresql://localhost:5432/airline_db
spring.datasource.username=${DB_USERNAME:postgres}
spring.datasource.password=${DB_PASSWORD}
```

The database must be created in PostgreSQL before running the application.

Database credentials should be configured locally and should not be committed to GitHub.

## How to Run the Application

1. Clone or download the project from GitHub.
2. Open the project in IntelliJ IDEA.
3. Make sure Java 21 and PostgreSQL are installed.
4. Create a PostgreSQL database named `airline_db`.
5. Configure the database username and password.
6. Allow Maven to download the required dependencies.
7. Run `AirlineapiApplication.java`.
8. Wait for Spring Boot to start successfully.

The application runs locally at:

`http://localhost:8080`

## Testing with Postman

Postman was used to test the API endpoints.

### Test 1: Retrieve Cities

**Method:** GET

**URL:** `http://localhost:8080/cities`

**Expected Result:**

- HTTP status 200 OK
- JSON response containing city information
- Related airport information where available

### Test 2: Retrieve Airports

**Method:** GET

**URL:** `http://localhost:8080/airports`

**Expected Result:**

- HTTP status 200 OK
- JSON response containing airport information
- Airport names, codes, and IDs

Both GET endpoints were tested successfully during development.

Additional CRUD endpoints will be tested as the remaining controllers are completed.

## Sample Data

Sample data is used to test the application and demonstrate the relationships between entities.

### Cities

- St. John&#39;s
- Toronto
- Vancouver

### Airports

- St. John&#39;s International Airport (YYT)
- Toronto Pearson International Airport (YYZ)
- Vancouver International Airport (YVR)

## Challenges and Solutions

### JSON Serialization

During testing, the `/cities` endpoint initially returned an HTTP 500 Internal Server Error.

This was caused by circular references between related entities when converting Java objects
into JSON.

Jackson annotations, including `@JsonIgnore`, were used to prevent repeated serialization.

After updating the entity relationships, the endpoint returned a successful 200 OK response.

### Package Organization

The project files were reorganized into separate packages for cities, airports, aircraft, and
passengers.

This made the code easier to navigate and kept related entity, repository, and controller files
together.

## Version Control

Git and GitHub are used to manage the project and track changes.

Commits document updates such as:

- Creating entity classes
- Adding repository interfaces
- Configuring database relationships
- Organizing project packages
- Updating API functionality

GitHub allows group members to share their work and collaborate.

## Team Contributions

This project was developed as a group assignment.

### Database Foundation and Structure

Responsibilities included:

- Creating and organizing entity classes
- Creating repository interfaces
- Setting up database relationships
- Adding sample data
- Organizing the package structure
- Testing database connections and API responses
- Troubleshooting JSON serialization issues

### Other Team Contributions

Add the remaining group members&#39; responsibilities, including controller development, additional
API features, testing, and documentation.

## Conclusion

This project demonstrates how Java, Spring Boot, and PostgreSQL can be used together to create
a REST API.

Through this project, our group gained experience with entity relationships, repositories, REST
endpoints, database configuration, API testing, and GitHub collaboration.

The application provides a foundation for managing airline information and can be expanded
with additional functionality in the future.
