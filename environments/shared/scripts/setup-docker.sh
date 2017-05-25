#!/bin/bash

# see https://docs.docker.com/engine/installation/linux/ubuntu/

echo "================="
echo "installing docker"
echo "================="

# per Ubuntu Trusty (14.04 LTS) 
# se fosse per Ubuntu Xenial (16.04 LTS), l'utente sarebbe ubuntu (e non vagrant, come per Ubuntu Trusty) 
VAGRANT_USER=vagrant 

##### install recommended extra packages 
apt-get update 

apt-get -y install curl \
    linux-image-extra-$(uname -r) \
    linux-image-extra-virtual
	
##### install docker using the repository 
sudo apt-get install -y --no-install-recommends \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common

curl -fsSL https://apt.dockerproject.org/gpg | sudo apt-key add -

apt-key fingerprint 58118E89F3A912897C070ADBF76221572C52609D

apt-get install software-properties-common

sudo add-apt-repository \
       "deb https://apt.dockerproject.org/repo/ \
       ubuntu-$(lsb_release -cs) \
       main"
	   
##### installa docker 
apt-get update

sudo apt-get -y install docker-engine

##### post-installation 

groupadd docker

# abilita l'utente vagrant 
sudo usermod -aG docker ${VAGRANT_USER}

##### configure docker to start on boot 

### Su Ubuntu 14.04 viene avviato di default 

### Su Ubuntu 16.04 invece bisogna fare quanto segue: 
# systemctl enable docker 

##### abilita l'accesso remoto 
# va usata la porta 2375 per l'accesso insicuro e la 2376 per quello sicuro con TLS 

# calcola il mio indirizzo IP (sulla rete 10.11.1.xx)
MY_IP_ADDR=$(ifconfig  | grep 'inet addr:'| grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $1}' | grep '10.11.1.')

### Istruzioni per Ubuntu 14.04: https://docs.docker.com/engine/admin/
# appende DOCKER_OPTS='-H tcp://0.0.0.0:2375 -H unix:///var/run/docker.sock' alla fine di /etc/default/docker
sudo echo "DOCKER_OPTS='-H tcp://${MY_IP_ADDR}:2375 -H unix:///var/run/docker.sock'" >> /etc/default/docker

### Per Ubuntu 16.04: https://docs.docker.com/engine/admin/systemd/
## da eseguire dopo systemctl enable docker (che crea il file docker.service) 
#sed '\_ExecStart_s_$_ -H tcp://'${MY_IP_ADDR}':2375 -H unix:///var/run/docker.sock_' /lib/systemd/system/docker.service > /tmp/docker.service.new
#mv /tmp/docker.service.new /lib/systemd/system/docker.service




