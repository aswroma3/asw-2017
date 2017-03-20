#!/bin/bash

# Script per avviare il servizio lucky-word 

echo Running with lucky word passed as an environment variable  

export LUCKY_WORD="Environment variable"

java -jar build/libs/lucky-word-0.0.1-SNAPSHOT.jar

unset LUCKY_WORD