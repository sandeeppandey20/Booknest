# BookNest

BookNest is a beginner-friendly Spring Boot MVC personal library management system built with Java 17, Spring Boot 3, Spring MVC, Spring Data JPA, Spring Security, Thymeleaf, Bootstrap 5, and MySQL-ready configuration.

## Features

- Admin login with Spring Security
- Dashboard statistics
- Book CRUD
- Search by title or author
- Validation and custom exception handling
- Bootstrap UI with Thymeleaf templates

## Run locally

```bash
mvn spring-boot:run
```

## Default admin credentials

- Username: `admin`
- Password: `admin123`

## Database

The project is configured to use H2 by default so it can run immediately in the workspace. To switch to MySQL, update the datasource values in `src/main/resources/application.properties`.
