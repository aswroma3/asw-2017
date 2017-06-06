#!/bin/bash

gradle build -b eureka-server/build.gradle 
gradle build -b word-service/build.gradle 
gradle build -b sentence-service/build.gradle 
gradle build -b zuul/build.gradle 




