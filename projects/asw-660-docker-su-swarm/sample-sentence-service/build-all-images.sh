#!/bin/bash

source "docker.env"

# DOCKER_REGISTRY=localhost:5000
DOCKER_REGISTRY=swarm.inf.uniroma3.it:5000

docker build --rm -t ${DOCKER_REGISTRY}/eureka-server-img ./eureka-server 
docker build --rm -t ${DOCKER_REGISTRY}/word-img ./word-service 
docker build --rm -t ${DOCKER_REGISTRY}/sentence-img ./sentence-service
docker build --rm -t ${DOCKER_REGISTRY}/sentence-zuul-img ./zuul






