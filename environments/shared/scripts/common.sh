#!/bin/bash

# l'utente Vagrant di default e' ${VAGRANT_USER} - di solito vagrant, ma talvolta ubuntu 

ASW_SHARED_RESOURCES=/home/${VAGRANT_USER}/shared/resources
ASW_SHARED_DOWNLOADS=/home/${VAGRANT_USER}/shared/downloads

function resourceExists {
	FILE=${ASW_SHARED_RESOURCES}/$1
	if [ -e $FILE ]
	then
		return 0
	else
		return 1
	fi
}

function downloadExists {
	FILE=${ASW_SHARED_DOWNLOADS}/$1
	if [ -e $FILE ]
	then
		return 0
	else
		return 1
	fi
}

function fileExists {
	FILE=$1
	if [ -e $FILE ]
	then
		return 0
	else
		return 1
	fi
}

#echo "common loaded"
