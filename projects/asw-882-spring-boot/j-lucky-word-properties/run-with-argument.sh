#!/bin/bash

# Script per avviare il servizio lucky-word 

echo Running with lucky word passed as an argument

java -jar build/libs/lucky-word-0.0.1-SNAPSHOT.jar --lucky.word=Argument

