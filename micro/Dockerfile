FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Create a non-root user
RUN useradd -m springuser
USER springuser

# UPDATE THIS LINE to match your actual file:
COPY target/micro-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]