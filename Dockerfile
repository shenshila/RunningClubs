# Первый этап: сборка приложения с использованием образа Maven
FROM maven:latest AS builder
# создаём рабочую директорию внутри контейнера (/app) и переходим в неё.
WORKDIR /app
# копируем файл pom.xml (файл конфигурации Maven) в контейнер.
COPY pom.xml .
# копируем исходный код приложения (src) в контейнер.
COPY src ./src
# запускаем Maven для сборки приложения
RUN mvn clean package -Dmaven.test.skip=true

# Второй этап: запуск приложения с использованием образа OpenJDK
FROM openjdk:17-jdk-slim
# создаём рабочую директорию внутри контейнера.
WORKDIR /app
# Копируем собранный JAR-файл из первого этапа (builder) в текущий контейнер под именем app.jar.
COPY --from=builder /app/target/RunningClubs-0.0.1-SNAPSHOT.jar app.jar
# указывает, что контейнер будет слушать входящие соединения на порту 8080
EXPOSE 8080
# команда для запуска JAR-файла в контейнере.
CMD ["java", "-jar", "app.jar"]