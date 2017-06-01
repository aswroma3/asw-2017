#!/bin/bash

# Script per avviare il servizio sentence 

echo Running ZUUL 

java -Xms64m -Xmx128m -jar build/libs/zuul-gateway-0.0.1-SNAPSHOT.jar

