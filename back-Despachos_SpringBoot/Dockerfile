# --- Etapa 1: Construcción (Build con Maven) ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app/Springboot-API-REST-DESPACHO
# Copiamos el archivo de dependencias y el código fuente
COPY Springboot-API-REST-DESPACHO/pom.xml ./
COPY Springboot-API-REST-DESPACHO/src ./src
# Compilamos el proyecto omitiendo la ejecución y compilación de tests para que sea más rápido
RUN mvn clean package -DskipTests -Dmaven.test.skip=true

# --- Etapa 2: Producción Segura (Multi-stage) ---
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Requisito de la Pauta: Crear y usar un usuario No-Root por seguridad
RUN addgroup --system spring && adduser --system --group spring
USER spring

# Copiamos el archivo .jar generado en la etapa 1
COPY --from=build /app/Springboot-API-REST-DESPACHO/target/*.jar app.jar

# Exponemos el puerto (por defecto Spring Boot usa el 8080)
EXPOSE 8080

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]