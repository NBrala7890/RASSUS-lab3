kubectl apply -f temperature-deployment.yaml

kubectl delete -f temperature-config.yaml

kubectl logs humidity-microservice-6789f8b9cb-22q6n

kubectl create configmap readings --from-file=C:\F___A___X\PRVI\RASSUS\lab_3\niksa_brala\k8s\config\readings.csv

kubectl create configmap application-properties --from-file=C:\F___A___X\PRVI\RASSUS\lab_3\niksa_brala\k8s\config\application.properties

kubectl get pods
kubectl get gateways -A
kubectl get configmaps
