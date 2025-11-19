# Workshop 5: Full Stack Student Manager (Spring Boot + Angular)

## 📌 Overview
This project represents the completion of **Workshop 5**, moving from a mock backend to a professional **Full Stack Architecture**. 
The application is a Student Management System that allows users to View, Add, Edit, and Delete students with persistent data storage.

## 🚀 Features
- **RESTful API:** Built with Spring Boot (Java).
- **Database:** - **PostgreSQL** for persistent data storage.
  - *H2 Database* (In-memory) used for initial testing.
- **Frontend Integration:** Connected to an Angular application (Standalone components).
- **Validation:** Backend business logic ensures students are at least 20 years old.
- **Error Handling:** Centralized exception handling for clean API responses.

## 🛠️ Tech Stack
- **Backend:** Java 17, Spring Boot 3.x, Spring Data JPA, Hibernate.
- **Database:** PostgreSQL 16.
- **Frontend:** Angular 17+, TypeScript, Bootstrap.
- **Tools:** Maven, Postman, IntelliJ IDEA, VS Code.

---

## ⚙️ Setup & Installation

### 1. Prerequisites
* Java 17+ installed.
* PostgreSQL installed and running.
* Node.js & Angular CLI installed.

### 2. Database Configuration
Open a terminal (or pgAdmin) and create the database:
```sql
CREATE DATABASE studentsdb;
