#!/bin/bash

# Script per avviare il servizio Eureka 

echo Running EUREKA 

java -Xms64m -Xmx128m -jar build/libs/common-eureka-server-0.0.1-SNAPSHOT.jar

