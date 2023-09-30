FROM maven:3.9.4-amazoncorretto-8 AS builder

WORKDIR /usr/app/

COPY . .

RUN mvn clean install -U

FROM eclipse-temurin:17-alpine

COPY --from=builder /usr/app/target/clinica-odontologica-1.0.0.jar /opt/app/application.jar

RUN addgroup -S spring && -S spring -G spring
USER spring:spring

CMD java -jar /opt/app/application.jar
