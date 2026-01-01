# ci-cd-docker-github
Java CI/CD with Docker & GitHub Actions
This repository demonstrates a professional A-Z Dockerized workflow for a Java 25 application. It covers everything from multi-stage builds and internal networking to automated deployment pipelines.

🏗 Architecture Overview
Runtime: Java 25 (Eclipse Temurin)

Build Tool: Maven 3.9+

Database: MySQL 8.0 (Official Image)

Orchestration: Docker Compose

CI/CD: GitHub Actions + Docker Hub

🛠 Features
1. Multi-Stage Dockerfile
The project uses a specialized Dockerfile to separate the Build Environment from the Runtime Environment.

Stage 1 (Build): Compiles code using JDK 25 and handles Maven dependency caching.

Stage 2 (Run): A lightweight Alpine JRE 25 image (approx. 150MB) for production.

Security: Runs as a non-root appuser.

2. Docker Compose Infrastructure
The docker-compose.yml file orchestrates the full stack:

Networking: A private bridge network allows the Java app to reach the database via the hostname db.

Persistence: A named volume (mysql-data) ensures database records survive container restarts.

Config: Environment variables map Spring Boot properties to Docker container names.

3. Automated CI/CD Pipeline
Every git push to the main branch triggers a GitHub Action that:

Checkouts the source code.

Logs into Docker Hub using encrypted secrets.

Builds the image using the local Dockerfile.

Pushes the versioned image to the registry.
