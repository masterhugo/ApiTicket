FROM openjdk:11.0-jdk-slim-stretch
CMD pwd
ARG DEPENDENCY=target
COPY ${DEPENDENCY}/api-ticket-1.0.0-SNAPSHOT.jar /home/api-ticket-1.0.0-SNAPSHOT.jar
RUN echo $ENVIROMENTS
ENTRYPOINT   [ "java","-jar","-Dspring.profiles.active=release","/home/api-ticket-1.0.0-SNAPSHOT.jar" ]
