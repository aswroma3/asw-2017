#!/bin/bash

# Script per avviare il servizio word come object 

echo Running as OBJECT  

java -Xms64m -Xmx128m -jar -Dspring.profiles.active=object build/libs/word-0.0.1-SNAPSHOT.jar

