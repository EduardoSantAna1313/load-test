#!/bin/bash

printf "### Removing the old container and image ... ###\n"

docker rm --force app-mock
docker rmi --force app-mock:v1 

clear

printf "\n### Building the image ###\n"
docker build -t app-mock:v1 .

printf "\nRunning the mock ###\n"
docker run -d -it --rm -p 8080:8080 --name app-mock app-mock:v1

sleep 5

printf "\n### Testing the mock server ###\n"
curl localhost:8080/hello
