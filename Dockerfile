FROM openjdk:17-alpine

LABEL maintainer="Mangesh Suryawanshi mangeshsu@cybage.com"

WORKDIR /app

COPY target/kanban-1.0.0.jar /app/

EXPOSE 8080

CMD ["java", "-jar", "kanban-1.0.0.jar"]