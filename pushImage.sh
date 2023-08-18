#!/bin/bash

set -e

echo [Start pushing docker image...]

imageTag=$1

if [ -z "$1" ]
  then
    echo No image tag provided. Latest will be used
    imageTag=latest
fi

repositoryName=837139758108.dkr.ecr.us-east-1.amazonaws.com/demo-kotlin
imageFullName=$repositoryName:$imageTag

echo [Main app STARTING...] pushing image $imageFullName

echo [Main app] pushing image...

docker push $imageFullName

echo [Main app FINISHED...] image $imageFullName has been pushed