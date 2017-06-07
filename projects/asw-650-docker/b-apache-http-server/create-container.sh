#!/bin/bash

docker create -v ~/docker/www:/var/www/html -p 8080:80 --name=apache apache-img 
