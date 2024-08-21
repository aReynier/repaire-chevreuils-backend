# 'Le repaire des chevreuils' guest house's API

## Overview

This is a RESTful API for managing the **fictive** 'Le repaire des chevreuils' guest house's booking system. The system allows clients to make bookings. Additionally, it provides an admin dashboard for overseeing all operations related to the guesthouse and manage  guest rooms, client profiles, and bookings. The API is built using Spring Boot and follows standard REST principles, ensuring it is easy to integrate with other systems.

## Features

- **Admin Management**
  - Secure authentication for the admin user.
  - Retrieve admin details.
  
- **Client Management**
  - CRUD operations for client profiles.
  - Store and manage client information, including contact details and address.
  
- **Booking Management**
  - CRUD operations for guest bookings.
  - Handle bookings with various options such as meal preferences and additional amenities.
  
- **Guest Room Management**
  - CRUD operations for guest rooms.
  - Track room details, including additional features and standard equipment.

## Technologies Used

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Swagger/OpenAPI** (for API documentation)
- **Maven** (for dependency management)

## Getting Started

### Prerequisites

- **Java 21**
- **Maven**
- **Docker & Docker Compose**

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/aReynier/repaire-chevreuils-backend.git
    ```
2. Navigate to the project directory:
    ```bash
    cd repaire-chevreuils-backend
    ```
3. If you're running the application locally, you can build and run it with Maven:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
4. **Alternatively, run the application using Docker Compose:**
    ```bash
    docker-compose up -d --build
    ```

5. The API documentation is automatically generated using Swagger and is accessible at:
    ```bash
    http://localhost:8080/swagger-ui.html
    ``` 

### Docker

The `Dockerfile` and the `docker-compose.yml` file are configured to set up the application and its dependencies in containers. This makes it easy to spin up the entire application with a single command.

### Contact
For questions or suggestions, please contact:
- Name: Aurore Reynier
- Email: reynier.aurore@gmail.com
- GitHub: https://github.com/aReynier