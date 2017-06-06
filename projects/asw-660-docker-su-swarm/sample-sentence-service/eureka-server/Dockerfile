########################################################
# Dockerfile per l'applicazione sentence / eureka server 
########################################################

FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/sentence-eureka-server-0.0.1-SNAPSHOT.jar sentence-eureka-server.jar

EXPOSE 8761

ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "sentence-eureka-server.jar"]

