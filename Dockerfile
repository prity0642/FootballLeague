FROM openjdk:8

MAINTAINER Prity Kumari12

COPY target/footballLeague-0.0.1-SNAPSHOT.jar footballApp.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/footballApp.jar"]
