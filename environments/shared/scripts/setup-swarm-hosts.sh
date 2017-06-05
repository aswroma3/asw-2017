#!/bin/bash

HOSTS_FILE=/etc/hosts 

function createModifiedHostsFile
{
	INFILE=$1 
	OUTFILE=$2 
	# Legge il file $INFILE e lo copia in $OUTFILE, ma: 
	# - aggiunge un # all'inizio delle linee che iniziano con 127.0.1.1 
	sed s/^'127.0.1.1'/'# 127.0.1.1'/ $INFILE > $OUTFILE
}

# aggiunge un # all'inizio delle linee che iniziano con 127.0.1.1 
# poi aggiunge a /etc/hosts le seguenti entry 
# - "10.11.1.71 swarm-1"
# - "10.11.1.72 swarm-2"
# - "10.11.1.73 swarm-3"
function setupSwarmHostsFile {
	echo "modifying 127.0.1.1 entries in /etc/hosts"
	createModifiedHostsFile ${HOSTS_FILE} ${HOSTS_FILE}.new 
	mv ${HOSTS_FILE} ${HOSTS_FILE}.bak
	mv ${HOSTS_FILE}.new ${HOSTS_FILE}
	
	echo "adding entris for swarm nodes to /etc/hosts"
	echo "10.11.1.71 swarm-1" >> ${HOSTS_FILE}
	echo "10.11.1.72 swarm-2" >> ${HOSTS_FILE}
	echo "10.11.1.73 swarm-3" >> ${HOSTS_FILE}
}

echo "setup /etc/hosts on a swarm node"
setupSwarmHostsFile