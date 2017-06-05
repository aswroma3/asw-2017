#!/bin/bash

echo 'Starting Docker Registry as a service' 

# docker service create --name registry --publish 5000:5000 --replicas 2 registry:2
docker service create --name registry --publish 5000:5000 registry:2
