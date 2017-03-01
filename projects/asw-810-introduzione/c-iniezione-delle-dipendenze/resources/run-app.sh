#!/bin/bash

# Script per l'avvio dell'app che utilizza il servizio Service  

echo Running my app 

# determina il path relativo in cui si trova lo script 
# (rispetto alla posizione da cui è stata richiesta l'esecuzione dello script) 
PATH_TO_SCRIPT=`dirname $0`

LIB_DIR=${PATH_TO_SCRIPT}/libs
APP_JAR=${LIB_DIR}/app.jar

java -cp "${LIB_DIR}/*" -Djava.util.logging.config.file=${PATH_TO_SCRIPT}/logging.properties -jar ${APP_JAR} 

