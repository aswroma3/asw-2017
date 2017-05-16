#!/bin/bash

# Script per elencare le risorse JMS disponibili 

ADMINPORT=4848
HOST=10.11.1.111

echo Listing JMS resources 

sudo asadmin --echo=true --host ${HOST} --port ${ADMINPORT} list-jms-resources 

