# Spring WebFlux MongoDB Example

This is a sample project demonstrating how to build a reactive web application using Spring WebFlux with MongoDB integration. It provides basic CRUD (Create, Read, Update, Delete) operations for managing users.

## Technologies Used

- Spring Boot
- Spring WebFlux
- Spring Data MongoDB
- MongoDB
- Reactor Core

## Project Structure

The project follows a layered architecture with the following components:

- **Handler Layer**: Handles incoming HTTP requests and delegates to the corresponding service methods.
- **Service Layer**: Contains business logic and interacts with the data access layer.
- **Data Access Object Layer**: Interfaces with the MongoDB database using Spring Data MongoDB.
- **Repository Layer**: Provides CRUD operations for managing entities.
- **Model/Entity**: Represents the data structure of a user.
- **DTO (Data Transfer Object)**: Represents the data transferred between layers.

## Functionality

- **GET /api/user**: Retrieve all users.
- **GET /api/user/{id}**: Retrieve a user by ID.
- **POST /api/user**: Create a new user.
- **PUT /api/user/{id}**: Update an existing user.
- **DELETE /api/user/{id}**: Delete a user by ID.

## Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/sikderg/demo-webflux-app.git
