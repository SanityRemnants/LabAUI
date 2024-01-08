FROM eclipse-temurin:17.0.6_10-jre

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:fleet-meneger-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV MENEGER_GATEWAY_HOST=localhost:8080
ENV MENEGER_SHIP_URL=http://localhost:8081
ENV MENEGER_FLEET_URL=http://localhost:8082

EXPOSE 8080

COPY FleetMenegerGateway2.jar /opt/fleet-meneger-gateway/FleetMenegerGateway2.jar

CMD ["java", "-jar", "/opt/fleet-meneger-gateway/FleetMenegerGateway2.jar"]
