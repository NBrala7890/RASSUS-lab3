#!/bin/bash

# https://traefik.io/blog/getting-started-with-kubernetes-gateway-api-and-traefik/

kubectl apply -f https://github.com/kubernetes-sigs/gateway-api/releases/download/v1.1.0/standard-install.yaml
kubectl apply -f https://raw.githubusercontent.com/traefik/traefik/v3.1/docs/content/reference/dynamic-configuration/kubernetes-gateway-rbac.yml

helm repo add traefik https://traefik.github.io/charts
helm repo update
helm upgrade --install --namespace kube-system traefik traefik/traefik -f values.yml
