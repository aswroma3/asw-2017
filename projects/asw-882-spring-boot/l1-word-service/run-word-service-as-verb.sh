#!/bin/bash

# Script per avviare il servizio word come verb 

echo Running as VERB  

java -Xms64m -Xmx128m -jar -Dspring.profiles.active=verb build/libs/word-0.0.1-SNAPSHOT.jar

