Emazon Users API
The Emazon Users API is designed for the creation and management of users for the Emazon app. This API handles user login and registration while managing authentication and authorization using Spring Security. Additionally, the API is documented with OpenAPI and Swagger, allowing for easy exploration and testing of endpoints.

Features
User Management: Create, update, and manage user profiles.
Authentication: Secure login functionality using Spring Security.
User Registration: Register new users with secure authentication processes.
API Documentation: Integrated OpenAPI documentation with Swagger.
Microservices Architecture: Designed as a scalable microservice for robust integration.
Technologies
Java
Spring Boot
Spring Security
RESTful API
Microservices Architecture
OpenAPI / Swagger
Getting Started
Prerequisites
Java 17 or higher
Gradle
Database SQL

Installation
Clone the repository:

bash
Copiar
Editar
git clone https://github.com/EstebanRCarmona/Api-users---emazon.git

Build the project:

Using Gradle:

bash
./gradlew build
Or, if using Maven:

bash
mvn clean install
Running the Application
To start the API, run:

The API will be available at http://localhost:8080.

API Endpoints

bash
http://localhost:8080/swagger-ui.html
This interface provides interactive documentation for all available endpoints, making it easy to understand and test the API.

Authentication
This API leverages Spring Security for robust authentication and authorization. It ensures that only authenticated users can access protected endpoints and that all sensitive operations are securely managed.

Contributing
Contributions are welcome! Please fork this repository and create a pull request with your improvements. For major changes, please open an issue first to discuss your ideas.


