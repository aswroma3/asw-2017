#!/bin/bash

docker create --name=data-volume data-volume-img 
docker start data-volume 

docker create --volumes-from data-volume -p 8080:80 --name=apache-data-volume apache-img
docker start apache-data-volume
