#!/usr/bin/env bash

set -e

cd "$(dirname "${BASH_SOURCE[0]}")/../"

minikube status || { echo 'minikube not running' && exit 1; }

eval $(minikube docker-env)

echo '* building app1'

(cd app1 && sbt docker:publishLocal)

docker images

echo '* building app2'

(cd app2 && sbt docker:publishLocal)

echo '* applying k8s yaml'

kubectl apply -f kubernetes/app1.yaml
kubectl apply -f kubernetes/app2.yaml
