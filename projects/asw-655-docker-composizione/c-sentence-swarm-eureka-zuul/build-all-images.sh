#!/bin/bash

docker build --rm -t localhost:5000/eureka-server-img ./eureka-server 
docker build --rm -t localhost:5000/word-img ./word-service 
docker build --rm -t localhost:5000/sentence-img ./sentence-service
docker build --rm -t localhost:5000/sentence-zuul-img ./zuul

docker push localhost:5000/eureka-server-img
docker push localhost:5000/word-img
docker push localhost:5000/sentence-img
docker push localhost:5000/sentence-zuul-img






