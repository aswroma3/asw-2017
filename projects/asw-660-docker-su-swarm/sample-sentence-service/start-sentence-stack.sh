#!/bin/bash

echo 'Starting sentence application as a stack' 

source "docker.env"

docker stack deploy --compose-file docker-stack-sentence.yml sentence
