#!/bin/bash

docker stop eureka 
docker stop subject 
docker stop verb 
docker stop object 
docker stop sentence 
docker stop zuul 

docker rm eureka 
docker rm subject 
docker rm verb 
docker rm object 
docker rm sentence 
docker rm zuul 

docker network rm eureka-net 



