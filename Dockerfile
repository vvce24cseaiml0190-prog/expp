# ==========================================
# STAGE 1: BUILD
# Maven + JDK 17
# ==========================================
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
# Copy Maven configuration
COPY pom.xml .
# Copy source code
COPY src ./src
# Download dependencies
RUN mvn dependency:go-offline -B
# Run JUnit tests
RUN mvn clean test
# ==========================================
# STAGE 2: RUNTIME
# JDK 17
# ==========================================
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copy generated JAR
COPY --from=build /app/target/*.jar app.jar
# Run application
ENTRYPOINT [&quot;java&quot;, &quot;-jar&quot;, &quot;app.jar&quot;]
