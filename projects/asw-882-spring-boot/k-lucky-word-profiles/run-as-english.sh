#!/bin/bash

# Script per avviare il servizio lucky-word 

echo Running as ENGLISH  

java -jar -Dspring.profiles.active=english build/libs/lucky-word-0.0.1-SNAPSHOT.jar

