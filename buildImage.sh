#!/bin/bash

set -e

echo [Start building docker image...]

imageTag=$1

if [ -z "$1" ]
  then
    echo No image tag provided. Latest will be used
    imageTag=latest
fi

repositoryName=837139758108.dkr.ecr.us-east-1.amazonaws.com/demo-kotlin
imageFullName=$repositoryName:$imageTag
./gradlew -version
echo [Main app STARTING...] building $imageFullName
(exec "${BASH_SOURCE%/*}/gradlew" dependencyUpdates  build --warning-mode=none)
docker build -t $imageFullName .
echo [Main app FINISHED...] image has been built