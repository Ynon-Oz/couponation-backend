FROM openjdk:11
COPY ./target/myService-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch couponation-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","couponation-0.0.1-SNAPSHOT.jar"]