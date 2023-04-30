# Project Name
Job Management System

# Frameworks and Language Used
**Spring Boot** 2.1.0
**Java** 11
**Maven** 3.8.1

# Data Flow
The following functions are used in the data flow of this project:

_**Controller:**_ The controller has endpoints for adding a user, getting all users, getting a user by their ID, and deleting a user by their ID. The @PostMapping annotation is used for the addUser endpoint to handle HTTP POST requests with a JSON request body containing a user object. The @Valid annotation is used to validate the user object against any defined validation constraints.

The @GetMapping annotation is used for the getAllUserList and getUserByUserId endpoints to handle HTTP GET requests with and without a path variable for the user ID, respectively. The @PathVariable annotation is used to extract the user ID from the request URL and pass it to the getUserById method.

The @DeleteMapping annotation is used for the deleteUserById endpoint to handle HTTP DELETE requests with a path variable for the user ID.

The controller class also has an autowired instance of the UserService interface to handle business logic for the User Management System.

This implementation demonstrates a basic setup for a REST API controller in Spring Boot, but it can be expanded upon and customized based on specific requirements for the User Management System.


_**Services**:_ The services layer contains the business logic of the application. It receives requests from the controller, performs necessary computations or data manipulations, and interacts with the repository layer to access data.

_**Repository:**_ The repository layer is responsible for interacting with the database. It uses Spring Data JPA to perform CRUD (create, read, update, delete) operations on entities.


# Database Structure Used
I have used ArrayList as DataBase

# Project Summary

In this project i have create different endpoints like and used differet vaalidation for the end ponits



