FROM openjdk:11-jdk-stretch  
ADD /target/muzixservices-0.0.1-SNAPSHOT.jar  /src/app/music/muzixservices-0.0.1-SNAPSHOT.jar
WORKDIR /src/app/music
ENTRYPOINT ["java","-jar","muzixservices-0.0.1-SNAPSHOT.jar"]
