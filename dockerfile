FROM maven:3.9-eclipse-temurin-25-alpine AS build
WORKDIR /app

# 1. Copy the ROOT pom and all module poms
COPY pom.xml .

# 2. Install the 'shared' module first so 'producer' can find it
RUN mvn install   # -pl = project list, -am = also make dependencies

# 3. Now build the producer
COPY . ./ci-cd-docker-github
WORKDIR /app/ci-cd-docker-github
RUN mvn package -DskipTests


# ==========================================
# STAGE 2: Runtime (JRE 25)
# ==========================================
# Switch to the small Runtime Environment for Java 25
FROM eclipse-temurin:25-jre-alpine

WORKDIR /app

# Professional standard: Non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

# Extract the JAR from the builder stage
COPY --from=build /app/ci-cd-docker-github/target/*.jar app.jar

# Standard Java 25 execution
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-Xmx512m", "-jar", "app.jar"]