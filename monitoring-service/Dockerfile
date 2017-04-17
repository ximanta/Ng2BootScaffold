FROM java:8-jre

ADD ./target/monitoring-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/monitoring-service.jar"]

EXPOSE 8989 8080