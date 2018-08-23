#!/usr/bin/env bash

cd "${0%/*}"
. common_config.sh
kubectl delete service,deployment springb-easy-notes-app
gcloud container images delete eu.gcr.io/zuhlke-kubernetes-codelab/springb-easy-notes-app:v1
