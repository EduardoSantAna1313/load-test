#!/bin/bash

printf "### Removing the old container and image ... ###\n"

docker rm --force load-test-wrk
docker rmi --force load-test-wrk:v1
clear

printf "\n### Building the image for WRK2 ###\n"
docker build -t load-test-wrk:v1 .

printf "\nRunning the load-test with WRK2 ###\n"
docker run -it --rm --network host --name load-test-wrk load-test-wrk:v1
