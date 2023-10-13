# Usar uma imagem base oficial de Java
FROM openjdk:8-jdk-alpine

# Argumento para especificar o JAR
ARG JAR_FILE=target/dojo-copilot-java-0.0.1-SNAPSHOT.jar

# Copiar o JAR do projeto para o container
COPY ${JAR_FILE} app.jar

# Expõe a porta 8080 para interagir com a aplicação
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
