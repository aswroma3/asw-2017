#!/bin/bash

# da eseguire sul nodo swarm-1 
# richiede che su ciascun nodo dello swarm sia abilitato l'accesso remoto 

echo "Creating swarm on swarm-1" 

docker swarm init --advertise-addr 10.11.1.71

SWARM_TOKEN=$(docker swarm join-token -q worker)
SWARM_MASTER=$(docker info --format "{{.Swarm.NodeAddr}}")

echo "Swarm master: ${SWARM_MASTER}"
echo "Swarm token: ${SWARM_TOKEN}"

echo "Adding swarm-2 and swarm-3" 

docker --host 10.11.1.72:2375 swarm join --token ${SWARM_TOKEN} ${SWARM_MASTER}:2377
docker --host 10.11.1.73:2375 swarm join --token ${SWARM_TOKEN} ${SWARM_MASTER}:2377