#!/usr/bin/env bash

cd "${0%/*}"

(cd .. && docker build -t eu.gcr.io/zuhlke-kubernetes-codelab/springb-easy-notes-app:v3 .)
gcloud docker -- push eu.gcr.io/zuhlke-kubernetes-codelab/springb-easy-notes-app:v3
kubectl edit deployment springb-easy-notes-app
kubectl get deployments