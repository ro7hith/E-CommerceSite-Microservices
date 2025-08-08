# 🛒 E-Commerce Site – Microservices-Based Full Stack Application

Welcome to the **E-Commerce Site**, a modern microservices-based web application designed to simulate a real-world online shopping platform. Built with **Spring Boot**, **Angular**, and deployed on **AWS**, this project demonstrates scalable service-oriented architecture and seamless integration between front-end and back-end components.


**Front-End with Angular - in Progress**

## 📦 Overview

This application features:
- A user-friendly shopping interface
- Admin panel for product and order management
- Microservices for catalog, order, payment, authentication, and user services
- Secure login and JWT-based authentication
- Cloud-deployed APIs with CI/CD pipelines

## 🚀 Tech Stack

**Frontend:** React   
**Backend:** Spring Boot (Java), Microservices  
**API Gateway:** Spring Cloud Gateway  
**Service Discovery:** Netflix Eureka  
**Security:** Spring Security, OAuth2, JWT  
**Databases:** MySQL, MongoDB (for product catalog), Redis (caching)  
**Message Queue (optional):** Apache Kafka or RabbitMQ  
**Cloud:** AWS EC2, S3, RDS  
**Containerization:** Docker  
**CI/CD:** Jenkins, GitHub Actions

---

## 🔐 Features

- User Registration and Secure Login (JWT-based)
- Role-based access for admin and customers
- Browse, search, and filter products
- Shopping cart and checkout
- Order history and status tracking
- Admin dashboard for product and order management
- Microservice communication via REST and Feign Clients
- Service registry using Eureka
- Centralized configuration (Spring Cloud Config)

---

## ⚙️ How to Run Locally

### Prerequisites:
- Java 17+
- Node.js & Angular CLI
- MySQL & MongoDB running locally
- Docker (optional for containerization)

### Backend Services

**Navigate into each microservice directory and run:**
mvn clean install
mvn spring-boot:run
Have to run each individual service as a Java Application if running from an IDE.

## Frontend
cd frontend
npm install
ng serve --open

Frontend runs at http://localhost:4200
API Gateway runs at http://localhost:8080

### 🧪 Testing

Unit Testing: JUnit, Mockito
Integration Tests for API endpoints
Postman Collection included for manual API testing

### ☁️ Deployment (Optional)
Backend deployed on AWS EC2 and RDS
Static front-end hosted via AWS S3 + CloudFront
Jenkins pipelines for CI/CD

### 📄 Future Enhancements
Add payment gateway integration
Implement Elasticsearch for advanced search
Add Prometheus + Grafana monitoring
Introduce shopping recommendations via ML
