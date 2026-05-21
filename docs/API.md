# Dar Faris HR System - REST API Documentation

## 📚 API Overview

Base URL: `http://localhost:8080/api`

### API Response Format

All responses are in JSON format with the following structure:

```json
{
  "data": {},
  "status": "success/error",
  "message": "Response message",
  "timestamp": "2024-05-21T10:30:00Z"
}
```

---

## 🏢 Department Endpoints

### List All Departments
```http
GET /departments
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Human Resources",
    "description": "Human Resources Department",
    "departmentHead": null,
    "budget": null,
    "isActive": true,
    "createdAt": "2024-05-21T09:00:00"
  }
]
```

---

### Get Active Departments
```http
GET /departments/active
```

**Response:** List of active departments only

---

### Get Department by ID
```http
GET /departments/{id}
```

**Example:**
```http
GET /departments/1
```

**Response:**
```json
{
  "id": 1,
  "name": "Human Resources",
  "description": "Human Resources Department",
  "isActive": true
}
```

---

### Create Department
```http
POST /departments
Content-Type: application/json

{
  "name": "IT Department",
  "description": "Information Technology Department",
  "budget": 100000,
  "isActive": true
}
```

**Response (201 Created):**
```json
{
  "id": 6,
  "name": "IT Department",
  "description": "Information Technology Department",
  "budget": 100000,
  "isActive": true,
  "createdAt": "2024-05-21T10:30:00"
}
```

---

### Update Department
```http
PUT /departments/{id}
Content-Type: application/json

{
  "name": "IT Department Updated",
  "description": "Updated Description",
  "budget": 120000,
  "isActive": true
}
```

**Response (200 OK):**
Updated department object

---

### Delete Department
```http
DELETE /departments/{id}
```

**Response (204 No Content)**

---

## 👥 Employee Endpoints

### List All Employees
```http
GET /employees
```

**Response:** Array of all employees

---

### Get Active Employees
```http
GET /employees/active
```

**Response:** Array of active employees only

---

### Get Employee by ID
```http
GET /employees/{id}
```

**Example:**
```http
GET /employees/1
```

**Response:**
```json
{
  "id": 1,
  "firstName": "Ahmed",
  "lastName": "Ali",
  "email": "ahmed@darfaris.com",
  "phone": "+966501234567",
  "employeeId": "EMP001",
  "position_id": 1,
  "department_id": 1,
  "hireDate": "2023-01-15",
  "salary": 5000,
  "isActive": true
}
```

---

### Get Employees by Department
```http
GET /employees/department/{departmentId}
```

**Example:**
```http
GET /employees/department/1
```

**Response:** Array of employees in the department

---

### Get Employees by Manager
```http
GET /employees/manager/{managerId}
```

**Response:** Array of employees reporting to the manager

---

### Create Employee
```http
POST /employees
Content-Type: application/json

{
  "userId": 1,
  "firstName": "Mohammed",
  "lastName": "Hassan",
  "email": "mohammed@darfaris.com",
  "phone": "+966501234568",
  "nationalId": "1234567890",
  "employeeId": "EMP002",
  "positionId": 1,
  "departmentId": 1,
  "hireDate": "2024-05-21",
  "salary": 4500,
  "employmentType": "FULL_TIME",
  "isActive": true
}
```

**Response (201 Created):**
Created employee object

---

### Update Employee
```http
PUT /employees/{id}
Content-Type: application/json

{
  "firstName": "Mohammed",
  "lastName": "Hassan",
  "phone": "+966501234568",
  "salary": 5000,
  "isActive": true
}
```

**Response (200 OK):**
Updated employee object

---

### Delete Employee (Soft Delete)
```http
DELETE /employees/{id}
```

**Response (204 No Content)**

Sets `isActive` to false instead of deleting

---

## 📅 Attendance Endpoints

### Record Attendance
```http
POST /attendance
Content-Type: application/json

{
  "employeeId": 1,
  "attendanceDate": "2024-05-21",
  "checkInTime": "08:30:00",
  "checkOutTime": "17:00:00",
  "status": "PRESENT",
  "notes": "Regular working day"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "employeeId": 1,
  "attendanceDate": "2024-05-21",
  "checkInTime": "08:30:00",
  "checkOutTime": "17:00:00",
  "status": "PRESENT",
  "notes": "Regular working day",
  "createdAt": "2024-05-21T08:30:00"
}
```

---

### Get Attendance by ID
```http
GET /attendance/{id}
```

**Response:**
```json
{
  "id": 1,
  "employeeId": 1,
  "attendanceDate": "2024-05-21",
  "checkInTime": "08:30:00",
  "checkOutTime": "17:00:00",
  "status": "PRESENT"
}
```

---

### Get Employee Attendance History
```http
GET /attendance/employee/{employeeId}
```

**Example:**
```http
GET /attendance/employee/1
```

**Response:** Array of all attendance records for the employee

---

### Get Employee Attendance in Date Range
```http
GET /attendance/employee/{employeeId}/range?startDate=2024-05-01&endDate=2024-05-31
```

**Example:**
```http
GET /attendance/employee/1/range?startDate=2024-05-01&endDate=2024-05-31
```

**Response:** Array of attendance records within the date range

---

### Update Attendance Record
```http
PUT /attendance/{id}
Content-Type: application/json

{
  "status": "LATE",
  "checkInTime": "09:15:00",
  "notes": "Traffic delay"
}
```

**Response (200 OK):**
Updated attendance object

---

## 🎯 Attendance Status Values

- `PRESENT` - Employee was present
- `ABSENT` - Employee was absent
- `LATE` - Employee arrived late
- `EARLY_LEAVE` - Employee left early
- `HALF_DAY` - Employee worked half day
- `ON_LEAVE` - Employee was on leave

---

## 💼 Position Endpoints

### List All Positions
```http
GET /positions
```

### Get Active Positions
```http
GET /positions/active
```

### Get Positions by Department
```http
GET /positions/department/{departmentId}
```

### Get Position by ID
```http
GET /positions/{id}
```

### Create Position
```http
POST /positions
Content-Type: application/json

{
  "title": "Senior Developer",
  "description": "Senior Software Developer Position",
  "departmentId": 4,
  "salaryRangeMin": 6000,
  "salaryRangeMax": 9000,
  "isActive": true
}
```

### Update Position
```http
PUT /positions/{id}
Content-Type: application/json
```

### Delete Position
```http
DELETE /positions/{id}
```

---

## 🔒 Authentication & Security

### User Roles
- `ADMIN` - Full system access
- `HR` - HR operations
- `MANAGER` - Department management
- `EMPLOYEE` - View own information

### JWT Token
Include in request header:
```
Authorization: Bearer <token>
```

---

## ⚠️ Error Responses

### 400 Bad Request
```json
{
  "error": "Bad Request",
  "message": "Invalid input data",
  "status": 400
}
```

### 404 Not Found
```json
{
  "error": "Not Found",
  "message": "Resource not found",
  "status": 404
}
```

### 401 Unauthorized
```json
{
  "error": "Unauthorized",
  "message": "Authentication required",
  "status": 401
}
```

### 403 Forbidden
```json
{
  "error": "Forbidden",
  "message": "Access denied",
  "status": 403
}
```

### 500 Internal Server Error
```json
{
  "error": "Internal Server Error",
  "message": "An error occurred",
  "status": 500
}
```

---

## 🧪 cURL Examples

### Get All Departments
```bash
curl -X GET http://localhost:8080/api/departments
```

### Create New Department
```bash
curl -X POST http://localhost:8080/api/departments \
  -H "Content-Type: application/json" \
  -d '{
    "name": "New Department",
    "description": "Description",
    "isActive": true
  }'
```

### Get Employee
```bash
curl -X GET http://localhost:8080/api/employees/1
```

### Record Attendance
```bash
curl -X POST http://localhost:8080/api/attendance \
  -H "Content-Type: application/json" \
  -d '{
    "employeeId": 1,
    "attendanceDate": "2024-05-21",
    "checkInTime": "08:30:00",
    "checkOutTime": "17:00:00",
    "status": "PRESENT"
  }'
```

---

## 📊 Query Parameters

### Pagination (Coming Soon)
```http
GET /employees?page=0&size=10&sort=lastName,asc
```

### Filtering (Coming Soon)
```http
GET /employees?departmentId=1&isActive=true
```

---

## 📝 Request/Response Examples

### Create Employee Request
```json
{
  "userId": 1,
  "firstName": "Ahmed",
  "lastName": "Ali",
  "middleName": "Mohammed",
  "email": "ahmed.ali@darfaris.com",
  "phone": "+966501234567",
  "nationalId": "1234567890",
  "dateOfBirth": "1990-05-15",
  "gender": "MALE",
  "maritalStatus": "MARRIED",
  "nationality": "Saudi Arabia",
  "employeeId": "EMP001",
  "positionId": 1,
  "departmentId": 1,
  "managerId": null,
  "hireDate": "2024-05-21",
  "employmentType": "FULL_TIME",
  "salary": 5000,
  "address": "Riyadh",
  "city": "Riyadh",
  "country": "Saudi Arabia",
  "emergencyContactName": "Fatima Ali",
  "emergencyContactPhone": "+966501234568",
  "isActive": true
}
```

---

## 🔄 Common API Workflows

### Workflow 1: Add New Employee

1. Create User account
2. Create Employee record linked to User
3. Record first day attendance
4. Set up employee positions

### Workflow 2: Record Attendance

1. Employee checks in
2. System records check-in time
3. Employee checks out
4. System records check-out time and calculates status

### Workflow 3: Generate Reports

1. Query employees by department
2. Query attendance records for date range
3. Generate report data
4. Export as PDF/Excel

---

## 📚 Additional Resources

- **Swagger UI**: http://localhost:8080/api/swagger-ui.html
- **Database Schema**: See `database/schema.sql`
- **Setup Guide**: See `docs/BACKEND_SETUP.md`

---

**Last Updated**: May 21, 2024
**Version**: 1.0.0
