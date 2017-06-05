#!/bin/bash

docker network create eureka-net 

# esegue piu' container di ogni tipo (tranne eureka e zuul) 

# docker run -d --network=eureka-net -p 8761:8761 --name=eureka eureka-server-img 
docker run -d --network=eureka-net --name=eureka eureka-server-img 

#docker run -d --network=eureka-net -P --name=subject-1 word-img -jar -Dspring.profiles.active=subject word.jar
## docker run -d --network=eureka-net -P --name=subject-2 word-img -jar -Dspring.profiles.active=subject word.jar
#docker run -d --network=eureka-net -P --name=verb-1 word-img -jar -Dspring.profiles.active=verb word.jar
## docker run -d --network=eureka-net -P --name=verb-2 word-img -jar -Dspring.profiles.active=verb word.jar
#docker run -d --network=eureka-net -P --name=object-1 word-img -jar -Dspring.profiles.active=object word.jar
## docker run -d --network=eureka-net -P --name=object-2 word-img -jar -Dspring.profiles.active=object word.jar

docker run -d --network=eureka-net --name=subject-1 word-img -jar -Dspring.profiles.active=subject word.jar
# docker run -d --network=eureka-net --name=subject-2 word-img -jar -Dspring.profiles.active=subject word.jar
docker run -d --network=eureka-net --name=verb-1 word-img -jar -Dspring.profiles.active=verb word.jar
# docker run -d --network=eureka-net --name=verb-2 word-img -jar -Dspring.profiles.active=verb word.jar
docker run -d --network=eureka-net --name=object-1 word-img -jar -Dspring.profiles.active=object word.jar
# docker run -d --network=eureka-net --name=object-2 word-img -jar -Dspring.profiles.active=object word.jar

#docker run -d --network=eureka-net -P --name=sentence-1 sentence-img 
#docker run -d --network=eureka-net -P --name=sentence-2 sentence-img 

docker run -d --network=eureka-net --name=sentence-1 sentence-img 
docker run -d --network=eureka-net --name=sentence-2 sentence-img 

docker run -d --network=eureka-net -p 8080:8080 --name=zuul zuul-img 





