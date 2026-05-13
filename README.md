# Employee Management System

A simple RESTful API for managing employee data using Spring Boot and MySQL.

## Features
- **CRUD Operations**: Create, Read, Update, and Delete employees.
- **Auto-Auditing**: Automatically tracks when records are created or updated.
- **Secure Config**: Uses a `.env` file to store database credentials safely.

## Tech Stack
- **Framework**: Spring Boot 3.2.5
- **Database**: MySQL
- **Language**: Java 17
- **Dependencies**: Spring Data JPA, Lombok, Dotenv

## API Endpoints
- `GET /api/employees` - List all employees
- `GET /api/employees/{id}` - Get details of one employee
- `GET /api/employees/department?department=HR` - Filter by department
- `GET /api/employees/sort?field=firstName&order=asc` - Sort by any field
- `GET /api/employees/paginate?page=0&size=5` - Get paginated results
- `POST /api/employees` - Add a new employee
- `PUT /api/employees/{id}` - Update an employee's info
- `DELETE /api/employees/{id}` - Remove an employee

## How to Run
1. Configure your database in the `.env` file.
2. Run `mvn spring-boot:run`.
3. Use the provided Postman collection to test the APIs.
