FROM amazoncorretto:11
MAINTAINER diegoluna
COPY target/DL-0.0.1-SNAPSHOT.jar diegoluna-portfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/diegoluna-portfolio-0.0.1-SNAPSHOT.jar"]
