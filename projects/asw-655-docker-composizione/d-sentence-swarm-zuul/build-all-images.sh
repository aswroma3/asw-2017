#!/bin/bash

docker build --rm -t localhost:5000/word-img-alt ./word-service 
docker build --rm -t localhost:5000/sentence-img-alt ./sentence-service
docker build --rm -t localhost:5000/sentence-zuul-img-alt ./zuul

docker push localhost:5000/word-img-alt
docker push localhost:5000/sentence-img-alt
docker push localhost:5000/sentence-zuul-img-alt






