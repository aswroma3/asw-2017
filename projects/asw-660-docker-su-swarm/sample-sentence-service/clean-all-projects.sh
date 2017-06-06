#!/bin/bash

gradle clean -b eureka-server/build.gradle 
gradle clean -b word-service/build.gradle 
gradle clean -b sentence-service/build.gradle 
gradle clean -b zuul/build.gradle 




