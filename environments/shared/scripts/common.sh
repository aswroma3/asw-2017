#!/bin/bash

# VAGRANT_USER è l'utente Vagrant di default che di solito, convenzionalmente, e' vagrant 
VAGRANT_USER=vagrant 

# dove vengono montate le risorse e i download condivisi 
VAGRANT_RESOURCES=/home/${VAGRANT_USER}/shared/resources
VAGRANT_DOWNLOADS=/home/${VAGRANT_USER}/shared/downloads

function resourceExists {
	FILE=${VAGRANT_RESOURCES}/$1
	if [ -e $FILE ]
	then
		return 0
	else
		return 1
	fi
}

function downloadExists {
	FILE=${VAGRANT_DOWNLOADS}/$1
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
