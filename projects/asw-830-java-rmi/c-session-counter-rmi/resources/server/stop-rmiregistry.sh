#!/bin/bash

# Script per l'arresto del registry RMI. 

# Uso: stop-rmiregistry 

echo Halting rmiregistry 

PID=`(ps -ef | grep rmiregistry | grep -v grep | awk '{ print $2 }')`
kill -9 ${PID}