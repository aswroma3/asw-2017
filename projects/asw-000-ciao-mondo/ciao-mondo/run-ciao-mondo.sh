#!/bin/bash

# Script per l'avvio dell'app ciao-mondo 

# determina il path relativo in cui si trova lo script 
# (rispetto alla posizione da cui è stata richiesta l'esecuzione dello script) 
PATH_TO_SCRIPT=`dirname $0`

LIB_DIR=${PATH_TO_SCRIPT}/build/libs
APP_JAR=${LIB_DIR}/ciao-mondo.jar

java -cp "${LIB_DIR}/*" -jar ${APP_JAR} 

