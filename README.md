# Pet Clinic REST API

A Spring Boot demo application providing a REST API for managing pet clinic owners.

## Prerequisites

- Java 17 or later
- Maven 3.6+

## Building

```bash
mvn clean package
```

## Running

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Documentation

### Owner Endpoints

#### GET /owners - Get All Owners

Retrieves a list of all owners.

```bash
curl --request GET --url http://localhost:8080/owners
```

**Response:**
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "address": "123 Main St",
    "city": "Springfield",
    "telephone": "555-1234"
  }
]
```

#### GET /owners/{id} - Get Owner by ID

Retrieves a specific owner by their ID.

```bash
curl --request GET --url http://localhost:8080/owners/1
```

**Response:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "address": "123 Main St",
  "city": "Springfield",
  "telephone": "555-1234"
}
```

#### POST /owners - Create Owner

Creates a new owner.

```bash
curl --request POST --url http://localhost:8080/owners --header 'Content-Type: application/json' --data '{"firstName": "Jane","lastName": "Smith","address": "456 Oak Ave","city": "Shelbyville","telephone": "555-5678"}'
```

**Response:**
```json
{
  "id": 2,
  "firstName": "Jane",
  "lastName": "Smith",
  "address": "456 Oak Ave",
  "city": "Shelbyville",
  "telephone": "555-5678"
}
```

## Testing

```bash
mvn test
```

## Technology Stack

- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (in-memory)
- Java 17
