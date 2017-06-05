#!/bin/bash

docker network create eureka-net 

# docker run -d --network=eureka-net -p 8761:8761 --name=eureka eureka-server-img 
docker run -d --network=eureka-net --name=eureka eureka-server-img 

#docker run -d --network=eureka-net -P --name=subject word-img -jar -Dspring.profiles.active=subject word.jar
#docker run -d --network=eureka-net -P --name=verb word-img -jar -Dspring.profiles.active=verb word.jar
#docker run -d --network=eureka-net -P --name=object word-img -jar -Dspring.profiles.active=object word.jar

docker run -d --network=eureka-net --name=subject word-img -jar -Dspring.profiles.active=subject word.jar
docker run -d --network=eureka-net --name=verb word-img -jar -Dspring.profiles.active=verb word.jar
docker run -d --network=eureka-net --name=object word-img -jar -Dspring.profiles.active=object word.jar

# docker run -d --network=eureka-net -p 8080:8080 --name=sentence sentence-img 
# docker run -d --network=eureka-net -P --name=sentence sentence-img 
docker run -d --network=eureka-net --name=sentence sentence-img 

docker run -d --network=eureka-net -p 8080:8080 --name=zuul zuul-img 





