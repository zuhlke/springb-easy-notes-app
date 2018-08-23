FROM openjdk:8-jdk-alpine
EXPOSE 8083

WORKDIR /opt/springb-easy-notes-app

COPY build/libs/springb-easy-notes-app-0.0.1-SNAPSHOT.jar ./

CMD java -Dspring.profiles.active=gcloud -jar springb-easy-notes-app-0.0.1-SNAPSHOT.jar