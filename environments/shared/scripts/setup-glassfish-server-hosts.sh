#!/bin/bash

HOSTS_FILE=/etc/hosts 
ENTRY_TO_ADD="10.11.1.111	glassfish"

function createModifiedHostsFile
{
	INFILE=$1 
	OUTFILE=$2 
	# Legge il file $INFILE e lo copia in $OUTFILE, ma: 
	# - aggiunge un # all'inizio delle linee che iniziano con 127.0 (127.0.0.1 e 127.0.1.1)
	sed s/^'127.0'/'# 127.0'/ $INFILE > $OUTFILE
}

# - aggiunge un # all'inizio delle linee che iniziano con 127.0.1.1 
# aggiunge "10.11.1.111 glassfish" a /etc/hosts 
function setupGlassfishServerHostsFile {
	echo "modifying /etc/hosts file"
	createModifiedHostsFile ${HOSTS_FILE} ${HOSTS_FILE}.new 
	mv ${HOSTS_FILE} ${HOSTS_FILE}.bak
	mv ${HOSTS_FILE}.new ${HOSTS_FILE}
	
	echo "adding ${ENTRY_TO_ADD}"
	echo "${ENTRY_TO_ADD}" >> ${HOSTS_FILE}
}

echo "setup glassfish server /etc/hosts file"
setupGlassfishServerHostsFile