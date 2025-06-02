# Task Manager API

A simple RESTful API built with Java and Spring Boot that allows users to manage tasks. This is a backend-only project showcasing core CRUD functionality for a task manager.

## Features

- ✅ View all tasks (`GET /tasks`)
- ✅ Create a new task (`POST /tasks`)
- ✅ Update an existing task (`PUT /tasks/{id}`)
- ❌ Delete task (coming soon)
- Data stored in-memory (no database for now)

## Tech Stack

- Java 21
- Spring Boot 3
- Maven
- REST API

## Getting Started

### Prerequisites

- Java 21+
- Maven

### Running the Application

```bash
# Clone the repository
git clone https://github.com/sagun347/taskmanager.git
cd taskmanager

# Run the application
./mvnw spring-boot:run
```

By default, the app runs at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint        | Description             |
|--------|------------------|-------------------------|
| GET    | `/tasks`         | Fetch all tasks         |
| POST   | `/tasks`         | Add a new task          |
| PUT    | `/tasks/{id}`    | Update a task by ID     |

## Example JSON for POST

```json
{
  "title": "My New Task",
  "completed": false
}
```

## Folder Structure

```
taskmanager/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── sagun/
│                   └── taskmanager/
│                       ├── models/
│                       │   └── Task.java
│                       ├── controllers/
│                       │   └── TaskController.java
│                       └── TaskManagerApiApplication.java
├── pom.xml
```

## Future Plans

- Add DELETE endpoint
- Save data to a database (e.g., PostgreSQL)
- Build a React or Vue.js front-end
- Add authentication

## Author

[Sagun347](https://github.com/sagun347)
