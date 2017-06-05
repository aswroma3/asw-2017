########################################################
# Dockerfile per l'applicazione sentence / word service 
########################################################

FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/word-0.0.1-SNAPSHOT.jar word.jar

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "word.jar"]

#CMD ["-jar", "-Dspring.profiles.active=subject", "word.jar"]
#CMD ["-jar", "-Dspring.profiles.active=verb", "word.jar"]
#CMD ["-jar", "-Dspring.profiles.active=object", "word.jar"]

