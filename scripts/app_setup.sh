#!/usr/bin/env bash

cd "${0%/*}"
. common_config.sh
docker images --format '{{.Repository}}:{{.Tag}}' | grep springb-easy-notes-app | xargs docker rmi -f
(cd .. && docker build -t eu.gcr.io/zuhlke-kubernetes-codelab/springb-easy-notes-app:v1 .)
gcloud docker -- push eu.gcr.io/zuhlke-kubernetes-codelab/springb-easy-notes-app:v1
kubectl run springb-easy-notes-app --image=eu.gcr.io/zuhlke-kubernetes-codelab/springb-easy-notes-app:v1 --port=8083
kubectl get deployments
kubectl get pods
kubectl cluster-info
kubectl expose deployment springb-easy-notes-app --type="LoadBalancer"