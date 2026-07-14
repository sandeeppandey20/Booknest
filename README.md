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

# Booknest
BookNest is a Spring Boot MVC web application for managing a personal book library. It demonstrates CRUD operations, Spring Security authentication, Hibernate (JPA), MySQL integration, exception handling, and Thymeleaf-based responsive UI following the MVC architecture.
# 📚 BookNest – Personal Library Management System

BookNest is a beginner-friendly **Java Spring Boot MVC** web application that helps users organize and manage their personal book collections. It provides a secure and intuitive interface for adding, viewing, updating, deleting, and searching books, making it an excellent project for learning modern Java web development.

The application follows the **Model-View-Controller (MVC)** architecture and incorporates industry-standard technologies such as **Spring Boot**, **Spring Data JPA (Hibernate)**, **Spring Security**, **Thymeleaf**, and **MySQL**. It also demonstrates essential backend development concepts, including layered architecture, repository and service patterns, global exception handling, form validation, and secure user authentication.

## ✨ Key Features

- 🔐 Secure Login & Authentication using Spring Security
- 📚 Complete CRUD Operations for Book Management
- 🔍 Search Books by Title, Author, or Genre
- 📊 Dashboard with Book Statistics
- ✅ Reading Status Management (Reading, Completed, Wishlist)
- 🛡 Global Exception Handling
- 🗄 Hibernate ORM with MySQL Integration
- 📝 Form Validation using Jakarta Validation
- 🎨 Responsive UI built with Thymeleaf & Bootstrap 5
- 🏛 Clean MVC Architecture with Repository & Service Layers

## 🛠 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring MVC
- Spring Data JPA (Hibernate)
- Spring Security
- MySQL
- Thymeleaf
- Bootstrap 5
- Maven
- Jakarta Bean Validation

## 🎯 Purpose

This project was developed to demonstrate the core concepts of enterprise Java web development in a simple, practical, and portfolio-ready application. It is suitable for academic submissions, internship projects, and showcasing Spring Boot development skills on GitHub.
