#!/bin/bash

# da eseguire dopo setup-docker, per configurare l'accesso non sicuro al registry swarm.inf.uniroma3.it:5000

# see https://docs.docker.com/engine/installation/linux/ubuntu/

echo "======================================"
echo "configuring swarm.inf.uniroma3.it:5000"
echo "======================================"

# Appende 192.168.161.168 swarm.inf.uniroma3.it a /etc/hosts
echo "192.168.161.168	swarm.inf.uniroma3.it" >> /etc/hosts 

### Istruzioni per Ubuntu 14.04: https://docs.docker.com/engine/admin/
# appende '--insecure-registry swarm.inf.uniroma3.it:5000' come parametro di DOCKER_OPTS alla fine di /etc/default/docker
sudo mv /etc/default/docker /etc/default/docker.bak 
sudo sed s/'docker.sock'/'docker.sock --insecure-registry swarm.inf.uniroma3.it:5000'/ /etc/default/docker.bak > /etc/default/docker

### Per Ubuntu 16.04: https://docs.docker.com/engine/admin/systemd/
# una variazione di quanto segue 
## da eseguire dopo systemctl enable docker (che crea il file docker.service) 
#sed '\_ExecStart_s_$_ -H tcp://'${MY_IP_ADDR}':2375 -H unix:///var/run/docker.sock_' /lib/systemd/system/docker.service > /tmp/docker.service.new
#mv /tmp/docker.service.new /lib/systemd/system/docker.service




