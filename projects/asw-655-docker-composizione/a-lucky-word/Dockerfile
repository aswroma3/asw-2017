########################################################
# Dockerfile per l'applicazione lucky-word 
########################################################

FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/lucky-word-0.0.1-SNAPSHOT.jar lucky-word.jar

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "-Dspring.profiles.active=english", "lucky-word.jar"]
