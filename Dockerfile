FROM fabric8/java-alpine-openjdk8-jdk
COPY ./build/libs/springboot-monitoring-app-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["java", "-Dspring.profiles.active=local","-jar", "springboot-monitoring-app-0.0.1-SNAPSHOT.jar"]


