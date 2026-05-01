FROM eclipse-temurin:17

WORKDIR /app

COPY . .

RUN javac src/main/java/Server.java

CMD ["java", "-cp", "src/main/java", "Server"]
