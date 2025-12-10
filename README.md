# Task Management System

A Spring Boot-based web application for managing tasks and user accounts. This project provides a complete solution for user registration, authentication, and task management with a PostgreSQL database backend.

## Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Configuration](#configuration)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Usage](#usage)
- [Build & Run](#build--run)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

Task Management System is a web-based application that allows users to:
- Register and create user accounts
- Log in securely with email and password authentication
- Create, manage, and organize tasks
- Track task information including task names and durations
- View their personal task dashboard

The application follows the MVC (Model-View-Controller) architecture pattern using Spring Boot and provides a clean separation of concerns with services, repositories, controllers, and entity layers.

## Tech Stack

### Backend
- **Framework**: Spring Boot 4.0.0
- **Language**: Java 17
- **Build Tool**: Maven
- **ORM**: Jakarta Persistence API (JPA) with Hibernate
- **Web**: Spring WebMVC
- **Database**: PostgreSQL
- **Development Tools**: Spring Boot DevTools

### Frontend
- **View Engine**: JSP (JavaServer Pages)
- **Template Location**: `/WEB-INF/views/`

### Dependencies
- Spring Boot Starter Data JPA
- Spring Boot Starter WebMVC
- PostgreSQL JDBC Driver
- Jakarta Persistence API
- Spring Boot DevTools (for rapid development)

## Features

### User Management
- **User Registration**: New users can create accounts with name, email, and password
- **User Authentication**: Secure login with email and password validation
- **Email Uniqueness**: Email addresses are enforced as unique identifiers
- **Session Management**: User sessions are tracked for authenticated operations

### Task Management
- **Create Tasks**: Authenticated users can create new tasks
- **Task Properties**: Each task includes:
  - Task ID (auto-generated)
  - Task Name
  - Duration (estimated time required)
  - Associated User Reference
- **User Association**: Tasks are automatically linked to the logged-in user
- **Task Persistence**: All tasks are persisted in the PostgreSQL database

### Security
- Session-based authentication
- User identification via email stored in HTTP sessions
- Password-protected accounts

## Prerequisites

Before you begin, ensure you have the following installed:

1. **Java Development Kit (JDK)**
   - Version 17 or higher
   - Set up JAVA_HOME environment variable

2. **Maven**
   - Version 3.6.0 or higher
   - Used for dependency management and project building

3. **PostgreSQL**
   - Version 12 or higher
   - Database server running locally or remotely accessible

4. **IDE (Optional but Recommended)**
   - IntelliJ IDEA, Eclipse, or Visual Studio Code
   - Spring Boot support extensions

## Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd com.taskmanagement
```

### 2. Create PostgreSQL Database
Connect to PostgreSQL and create the database:

```sql
CREATE DATABASE taskmanagement;
```

### 3. Configure Database Credentials
Edit `src/main/resources/application.properties` and update the following values:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanagement
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password
```

### 4. Build the Project
Navigate to the project root directory and run:

```bash
mvn clean install
```

This will:
- Clean any previous builds
- Download all dependencies
- Compile the source code
- Run tests
- Create a JAR file in the `target/` directory

### 5. Run the Application
```bash
mvn spring-boot:run
```

Or run the JAR file directly:
```bash
java -jar target/com.taskmanagement-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080` by default.

## Configuration

### Application Properties
Located in `src/main/resources/application.properties`

```properties
# Application Name
spring.application.name=com.taskmanagement

# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanagement
spring.datasource.username=postgres
spring.datasource.password=zeeshan
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate/JPA Configuration
spring.jpa.hibernate.ddl-auto=update  # Auto-creates/updates database schema
spring.jpa.show-sql=true              # Logs SQL queries to console
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# View Configuration (JSP)
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

### Key Configuration Details
- **ddl-auto=update**: Automatically updates the database schema based on entity definitions
- **show-sql=true**: Useful for development; disable in production for performance
- **JSP View Prefix/Suffix**: Routes view requests to the `/WEB-INF/views/` directory with `.jsp` extension

## Project Structure

```
com.taskmanagement/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── taskmanagement/
│   │   │           ├── Application.java              # Spring Boot entry point
│   │   │           ├── controller/
│   │   │           │   ├── TaskController.java       # Handles task-related requests
│   │   │           │   └── UserController.java       # Handles user-related requests
│   │   │           ├── entity/
│   │   │           │   ├── Task.java                 # Task JPA entity
│   │   │           │   ├── Userss.java               # User JPA entity
│   │   │           │   └── LoginUser.java            # Login request model
│   │   │           ├── repository/
│   │   │           │   ├── TaskRepository.java       # Task data access layer
│   │   │           │   └── UserRepository.java       # User data access layer
│   │   │           └── service/
│   │   │               ├── TaskService.java          # Task business logic interface
│   │   │               ├── TaskServiceImpl.java       # Task service implementation
│   │   │               ├── UserService.java          # User business logic interface
│   │   │               └── UserServiceImpl.java       # User service implementation
│   │   ├── resources/
│   │   │   ├── application.properties                # Spring Boot configuration
│   │   │   ├── static/                               # Static files (CSS, JS, images)
│   │   │   └── templates/
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           └── views/
│   │               ├── home.jsp                      # Home/dashboard page
│   │               ├── login.jsp                     # Login page
│   │               ├── register.jsp                  # User registration page
│   │               └── task.jsp                      # Task creation page
│   └── test/
│       └── java/com/taskmanagement/
│           └── ApplicationTests.java                 # Unit tests
├── pom.xml                                           # Maven configuration
├── mvnw / mvnw.cmd                                  # Maven wrapper scripts
└── README.md                                        # This file
```

## Database Schema

### Users Table (`userss`)
```sql
CREATE TABLE userss (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255),
  tasks JSON
);
```

### Tasks Table (`task`)
```sql
CREATE TABLE task (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  duration VARCHAR(255),
  userss_id INTEGER FOREIGN KEY REFERENCES userss(id)
);
```

## API Endpoints

### User Management

| Method | Endpoint | Description | Returns |
|--------|----------|-------------|---------|
| GET | `/` | Display registration page | register.jsp |
| POST | `/createuser` | Create a new user account | Redirect to login |
| POST | `/login` | Authenticate user | Redirect to home or login |
| GET | `/home` | Display user dashboard (requires auth) | home.jsp |

### Task Management

| Method | Endpoint | Description | Returns |
|--------|----------|-------------|---------|
| POST | `/createTask` | Display task creation form | task.jsp |
| POST | `/saveTask` | Save a new task for authenticated user | Redirect to home or task form |

## Usage

### 1. Register a New User
1. Navigate to `http://localhost:8080/`
2. Fill in the registration form with:
   - Name
   - Email (must be unique)
   - Password
3. Submit the form
4. User account is created and stored in the database

### 2. Log In
1. Go to the login page
2. Enter your email and password
3. Upon successful authentication, you'll be redirected to the home dashboard
4. A session will be created with your email

### 3. Create a Task
1. From the home dashboard, click on "Create Task"
2. Fill in the task details:
   - Task Name
   - Duration
3. Submit the form
4. The task is saved and associated with your user account

### 4. View Tasks
1. Tasks appear on your home dashboard
2. All tasks are linked to your user account via the user session

## Build & Run

### Using Maven (Recommended)
```bash
# Clean and build
mvn clean install

# Run the application
mvn spring-boot:run
```

### Using JAR
```bash
# Build the JAR
mvn clean package

# Run the JAR
java -jar target/com.taskmanagement-0.0.1-SNAPSHOT.jar
```

### Using Maven Wrapper (Windows)
```bash
# Build
mvnw.cmd clean install

# Run
mvnw.cmd spring-boot:run
```

### Access the Application
Once running, open your browser and navigate to:
```
http://localhost:8080
```

## Development Tips

### Enable Detailed Logging
To see SQL queries and Hibernate operations, ensure `spring.jpa.show-sql=true` is set in `application.properties`.

### Hot Reload with DevTools
Spring Boot DevTools is included, which enables:
- Automatic application restart when files change
- Live reload for static files
- Faster development cycle

### Testing
Run tests with:
```bash
mvn test
```

## Troubleshooting

### Database Connection Issues
- Verify PostgreSQL is running
- Check database credentials in `application.properties`
- Ensure the `taskmanagement` database exists
- Check firewall settings for port 5432

### Application Won't Start
- Verify Java 17 is installed: `java -version`
- Check Maven installation: `mvn -version`
- Clear Maven cache: `mvn clean`
- Check application logs for detailed errors

### JSP Pages Not Rendering
- Verify files exist in `/src/main/resources/webapp/WEB-INF/views/`
- Check view prefix/suffix in `application.properties`
- Ensure correct file extensions (`.jsp`)

## Contributing

To contribute to this project:

1. Create a feature branch (`git checkout -b feature/AmazingFeature`)
2. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
3. Push to the branch (`git push origin feature/AmazingFeature`)
4. Open a Pull Request

## Future Enhancements

Potential improvements for future versions:
- Add task update and delete functionality
- Implement task categories/labels
- Add task priority levels
- Create a REST API for mobile client access
- Add email verification for registration
- Implement password reset functionality
- Add role-based access control (Admin, User)
- Create task filtering and search
- Add task due dates and reminders
- Implement task completion status tracking

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For issues, questions, or suggestions, please open an issue in the repository or contact the development team.

---

**Project Version**: 0.0.1-SNAPSHOT  
**Java Version**: 17  
**Spring Boot Version**: 4.0.0  
**Last Updated**: December 2025
