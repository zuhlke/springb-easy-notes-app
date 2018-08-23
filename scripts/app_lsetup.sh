#!/usr/bin/env bash

cd "${0%/*}"
. common_config.sh
docker images --format '{{.Repository}}:{{.Tag}}' | grep springb-easy-notes-app | xargs docker rmi -f
(cd .. && docker build -t eu.gcr.io/zuhlke-kubernetes-codelab/springb-easy-notes-app:v1 .)
docker run -d -p 8083:8083 --link easy-notes-db:mongo --name=springb-easy-notes-app eu.gcr.io/zuhlke-kubernetes-codelab/springb-easy-notes-app:v1