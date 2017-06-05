#!/bin/bash

docker stop eureka 
docker stop subject-1 
docker stop verb-1 
docker stop object-1 
docker stop sentence-1 
docker stop sentence-2
docker stop zuul 

docker rm eureka 
docker rm subject-1 
docker rm verb-1 
docker rm object-1 
docker rm sentence-1 
docker rm sentence-2 
docker rm zuul 

docker network rm eureka-net 



