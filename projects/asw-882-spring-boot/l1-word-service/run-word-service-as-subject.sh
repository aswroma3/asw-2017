#!/bin/bash

# Script per avviare il servizio word come subject 

echo Running as SUBJECT  

java -Xms64m -Xmx128m -jar -Dspring.profiles.active=subject build/libs/word-0.0.1-SNAPSHOT.jar

