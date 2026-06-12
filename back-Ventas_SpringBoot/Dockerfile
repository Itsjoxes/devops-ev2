# --- Etapa 1: Construcción (Build con Maven) ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiamos el pom y el código fuente del proyecto de ventas
COPY Springboot-API-REST/pom.xml ./Springboot-API-REST/
COPY Springboot-API-REST/src ./Springboot-API-REST/src

WORKDIR /app/Springboot-API-REST
# Skip test compilation and execution inside the container
RUN mvn clean package -DskipTests -Dmaven.test.skip=true

# --- Etapa 2: Producción Segura (Multi-stage) ---
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Crear y usar usuario no-root por seguridad
RUN addgroup --system spring && adduser --system --group spring
USER spring

COPY --from=build /app/Springboot-API-REST/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
