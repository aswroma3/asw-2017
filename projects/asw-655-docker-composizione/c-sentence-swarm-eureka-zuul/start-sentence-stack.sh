#!/bin/bash

echo 'Starting sentence application as a stack' 

docker stack deploy --compose-file docker-stack-sentence.yml sentence
