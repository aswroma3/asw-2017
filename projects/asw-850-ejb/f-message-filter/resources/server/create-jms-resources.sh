#!/bin/bash

# Script per la creazione delle risorse JMS per le applicazioni asw850 

ADMINPORT=4848
HOST=10.11.1.111

QUEUE_ONE_NAME=jms/asw/ejb/QueueOne
QUEUE_TWO_NAME=jms/asw/ejb/QueueTwo
CFNAME=jms/asw/ConnectionFactory

echo Creating JMS resources for asw850

sudo asadmin --echo=true --host ${HOST} --port ${ADMINPORT} create-jms-resource --restype javax.jms.Queue --enabled=true ${QUEUE_ONE_NAME} 

sudo asadmin --echo=true --host ${HOST} --port ${ADMINPORT} create-jms-resource --restype javax.jms.Queue --enabled=true ${QUEUE_TWO_NAME} 

sudo asadmin --echo=true --host ${HOST} --port ${ADMINPORT} create-jms-resource --restype javax.jms.ConnectionFactory --enabled=true ${CFNAME} 

echo JMS resources for asw850 created
