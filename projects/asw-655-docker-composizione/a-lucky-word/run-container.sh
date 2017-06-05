#!/bin/bash

docker run -d -p 8080:8080 --name=lucky-word lucky-word-img 
#docker run -d -p 8080:8080 --name=lucky-word lucky-word-img -jar -Dspring.profiles.active=italian lucky-word.jar
#docker run -d --network=eureka-net -p 8080:8080 --name=lucky-word lucky-word-img -jar -Dspring.profiles.active=italian lucky-word.jar



