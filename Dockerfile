FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos primero los archivos de build para aprovechar cache de dependencias.
COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
RUN mvn -q -DskipTests dependency:go-offline

# Copiamos el código y compilamos el jar de Spring Boot.
COPY src src
RUN mvn -q -DskipTests clean package

FROM eclipse-temurin:21-jre
WORKDIR /app

EXPOSE 8080
COPY --from=build /app/target/bibliotecavirtual-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
