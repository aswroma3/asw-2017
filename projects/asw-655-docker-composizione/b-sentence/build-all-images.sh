#!/bin/bash

docker build --rm -t eureka-server-img ./eureka-server 
docker build --rm -t word-img ./word-service 
docker build --rm -t sentence-img ./sentence-service
docker build --rm -t zuul-img ./zuul








