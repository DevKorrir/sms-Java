# Student Management System (SMS) - Java

A Java-based Student Management System featuring a JavaFX user interface and MariaDB/MySQL database integration, built with Gradle.

## Features
- **View Students**: Displays student records in a responsive `TableView`.
- **Add Students**: Input fields to register new students (Registration Number, Name, Course).
- **Database Persistence**: Uses JDBC with MariaDB for reliable data storage.
- **JavaFX UI**: Modern desktop interface using FXML and CSS.

## Prerequisites
- **Java Development Kit (JDK) 21**: The project uses Java 21 features and toolchains.
- **MariaDB or MySQL Server**: To store student records.
- **Gradle**: (Optional) The project includes a Gradle wrapper (`./gradlew`).

## Setup and Configuration

### 1. Database Setup
Create a database named `student_db` and a table named `students`. You can use the following SQL script:

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reg_no VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL
);
```

### 2. Configure Credentials
Update the database connection details in `src/main/resources/db.properties`:

```properties
db.url=jdbc:mariadb://localhost:3306/student_db
db.user=your_username
db.password=your_password
```

## How to Run

### Using Gradle Wrapper
Navigate to the project root directory and run:

```bash
# On Linux/macOS
./gradlew run

# On Windows
gradlew.bat run
```

### Build the Project
To compile and build the JAR file:

```bash
./gradlew build
```

## Troubleshooting

### Graphics/Prism Errors
If you encounter errors like `Prism ES2 Error - nInitialize: glXChooseFBConfig failed`, the application is configured to automatically fall back to software rendering using:
`-Dprism.order=sw,es2,d3d`

### Java Module System (JPMS)
This project is fully modularized. If you add new models or packages that need to be accessed by JavaFX via reflection (e.g., for `TableView` properties), ensure they are opened in `src/main/java/module-info.java`:

```java
opens com.example.sms_java.model to javafx.base;
```

## Project Structure
- `src/main/java/com/example/sms_java/MainApp.java`: Application entry point.
- `src/main/java/com/example/sms_java/controller/StudentController.java`: FXML controller for the student view.
- `src/main/java/com/example/sms_java/dao/StudentDAO.java`: Data Access Object for student operations.
- `src/main/java/com/example/sms_java/db/DatabaseConnection.java`: Utility for database connectivity.
- `src/main/java/com/example/sms_java/model/Student.java`: Student entity class.
- `src/main/resources/com/example/sms_java/student-view.fxml`: UI layout definition.

```css
student-management-system
│
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
│
└── src
    └── main
        ├── java
        │   └── com.example.studentms
        │       ├── MainApp.java
        │       │
        │       ├── db
        │       │   └── DatabaseConnection.java
        │       │
        │       ├── model
        │       │   └── Student.java
        │       │
        │       ├── dao
        │       │   └── StudentDAO.java
        │       │
        │       └── controller
        │           └── StudentController.java
        │
        └── resources
            └── application.css
```

