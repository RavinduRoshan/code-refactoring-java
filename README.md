# Movie Rental Application

The Movie Rental Application is a Java-based system that allows users to rent movies and generate rental summaries for customers. 
This application is built using Maven for dependency management and project build.

## Features

- Rent movies: Users can rent movies by specifying the customer name and the list of movies to rent.
- Generate rental summaries: The application generates rental summaries for customers, including the total amount owed and frequent renter points earned.
- Support for various movie types: The application supports different types of movies, such as regular, children, and new release movies.

## Prerequisites

- JDK 17 installed on your machine.
- Maven 3.9.6 installed on your machine.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/RavinduRoshan/code-refactoring-java
   
2. Build the project using Maven:

    ```bash
   mvn clean package

3. Run the tests

   ```bash
   mvn clean test

4. Run the application:

    ```bash
     java -jar target/code-refactoring-java-1.0-SNAPSHOT.jar

## Changeset
### Maven Integration

Maven is adopted to manage project dependencies and structure, simplifying project management and facilitating build automation.

### Design Patterns

- **Factory Pattern**: Implemented to encapsulate the creation of rental strategies, promoting flexibility and maintainability.
- **Singleton Pattern**: `MovieRepositoryImpl` class is made a singleton to ensure a single instance is used throughout the application, enhancing resource efficiency and consistency.

### Modularization

Codebase is segregated into different packages and classes based on functionality, improving code organization and readability.

### Unit Testing

Unit tests are implemented to validate business logic, ensuring the correctness of application behavior and facilitating future changes without regressions.

### Custom Exceptions

Custom exceptions, such as `InvalidCustomerException`, are introduced to provide meaningful error handling and improve fault tolerance.

### Repository Implementation

`MovieRepository` interface and `MovieRepositoryImpl` class are created to abstract data retrieval operations, promoting separation of concerns and enabling easier data source switching.

### Constants

Constants are introduced for commonly used values, enhancing code readability and maintainability by providing descriptive names for literals.

### Javadocs

Javadocs are added to classes and methods to provide comprehensive documentation, improving code understanding and facilitating future maintenance.

### Java Records

Java records are utilized for concise representation of data entities, enhancing code clarity and reducing boilerplate code.

### Movie Rental Strategies

Multiple movie rental strategy implementations, such as `RegularPricingStrategy`, `ChildrenPricingStrategy`, and `NewReleasePricingStrategy`, are implemented, allowing flexible pricing rules based on movie types.

### Abstraction with Interfaces

Interfaces, such as `RentalService` and `RentalStrategy`, are introduced to abstract functionality and enable interchangeable implementations, promoting loose coupling and scalability.

### SOLID Principles

SOLID design principles, such as Single Responsibility Principle (SRP) and Dependency Inversion Principle (DIP), are adhered to ensure code maintainability, extensibility, and testability.
