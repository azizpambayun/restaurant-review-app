# Restaurant Review App

This is a full-stack web application for browsing and reviewing restaurants. It allows users to search for restaurants, view details, and write their own reviews with ratings and photos.

---

## Features

* **Restaurant Search:** Search for restaurants by name, cuisine, or location.
* **Restaurant Listings:** View a paginated list of restaurants with summary information.
* **Detailed Restaurant View:** See comprehensive details for a specific restaurant, including:
    * Address and map location
    * Contact information
    * Operating hours
    * Average rating
    * User reviews
* **User Reviews:**
    * Authenticated users can write, edit, and delete their own reviews.
    * Reviews can include a star rating (1-5), written content, and photos.
* **Photo Uploads:** Users can upload photos for restaurants and reviews.
* **Authentication:** User authentication is handled using Keycloak.

---

## Tech Stack

### Backend

* **Framework:** Spring Boot 3
* **Language:** Java 24
* **Database:** Elasticsearch
* **Authentication:** Spring Security with OAuth2/JWT and Keycloak
* **API:** RESTful API
* **Dependencies:**
    * Lombok
    * MapStruct

### Frontend

* **Framework:** Next.js 14
* **Language:** TypeScript
* **Styling:** Tailwind CSS
* **UI Components:** Shadcn UI, Radix UI
* **State Management:** React Hooks and Context API
* **API Client:** Axios
* **Authentication:** react-oidc-context

---

## Getting Started

### Prerequisites

* Java 24+
* Maven
* Node.js and npm
* Docker (for Elasticsearch and Keycloak)

### Backend Setup

1.  Navigate to the `backend` directory.
2.  Start the services using Docker Compose:
    ```bash
    docker-compose up
    ```
3.  Run the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```

### Frontend Setup

1.  Navigate to the `frontend` directory.
2.  Install dependencies:
    ```bash
    npm install
    ```
3.  Run the development server:
    ```bash
    npm run dev
    ```

---
