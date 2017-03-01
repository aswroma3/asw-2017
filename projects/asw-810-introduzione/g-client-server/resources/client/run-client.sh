#!/bin/bash

# Script per l'avvio del client per un servizio. 

echo Running client 

# Uso: run-client [indirizzo-del-server] 
# Se l'indirizzo-del-server non è specificato, il default è localhost (e non 10.11.1.101). 

if [ $# -gt 0 ] 
then SERVERHOST=$1
else SERVERHOST="localhost"
fi 

echo Starting client - server su ${SERVERHOST}

# determina il path relativo in cui si trova lo script 
# (rispetto alla posizione da cui è stata richiesta l'esecuzione dello script) 
PATH_TO_SCRIPT=`dirname $0`

LIB_DIR=${PATH_TO_SCRIPT}/libs
CLIENT_JAR=${LIB_DIR}/client.jar

java -cp "${LIB_DIR}/*" -Djava.util.logging.config.file=${PATH_TO_SCRIPT}/logging.properties -jar ${CLIENT_JAR} ${SERVERHOST}


