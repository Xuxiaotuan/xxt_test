# xxt_test

This is a Spring Boot application with a basic scaffolding structure.

## Project Structure

```
src
├── main
│   ├── java
│   │   └── cn.xuyinyin.magic
│   │       ├── XjwApplication.java         # Main application class
│   │       ├── config                      # Configuration classes
│   │       ├── controller                  # REST controllers
│   │       ├── entity                      # JPA entities
│   │       ├── exception                   # Exception handlers
│   │       ├── repository                  # JPA repositories
│   │       └── service                     # Business logic services
│   └── resources
│       ├── application.yml                 # Application configuration
│       ├── banner.txt                      # Custom banner
│       └── logback-spring.xml             # Logging configuration
└── test                                    # Test classes
    └── java
        └── cn.xuyinyin.magic
```

## Technologies Used

- Java 17
- Spring Boot 3.3.12
- Maven
- Lombok
- JPA/Hibernate
- H2 Database (in-memory for development)

## Endpoints

- `GET /` - Basic "Hello World" endpoint
- `GET /api/hello` - Sample endpoint with service layer
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create a new user
- `GET /api/users/email/{email}` - Get user by email
- `/h2-console` - H2 database console (for development)

## Building and Running

To build the application:
```bash
mvn clean package
```

To run the application:
```bash
mvn spring-boot:run
```

Or:
```bash
java -jar target/xxt_test-0.0.1-SNAPSHOT.jar
```

## Docker

To build and run with Docker:
```bash
docker build -t xxt_test .
docker run -p 9002:9002 xxt_test
```

