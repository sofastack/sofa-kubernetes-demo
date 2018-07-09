# SOFA Kubernetes Demo

This demo is aimed to demonstrate how SOFA run in Kubernetes.

## How to run this demo

1. Install [minikube](https://kubernetes.io/docs/setup/minikube/) in your desktop.
2. Run `minikube start` to start minikube.
3. Run `kubectl apply -f zookeeper.yml` to install zookeeper in minikube.
3. Run `kubectl apply -f zookeeper-service.yml` to create a Service for zookeeper.
4. Run `kubectl apply -f zipkin.yml` to install Zipkin in minikube.
5. Run `kubectl apply -f zipkin-service.yml` to create a Service for Zipkin.
6. Run `eval $(minikube docker-env)` to change the docker env to minikube.
7. Change directory to rpcserver than run `mvn clean package` to package rpcserver.
8. Run `docker build --build-arg JAR_FILE=./target/rpcserver-0.0.1-SNAPSHOT.jar . -t rpc-server` to build a docker image for rpcserver
9. Change directory to rpcclient than run `mvn clean package` to package rpcclient.
10. Run `docker build --build-arg JAR_FILE=./target/rpcclient-0.0.1-SNAPSHOT.jar . -t rpc-client` to build a docker image for rpcclient.
11. Change directory to the root of this project and run `kubectl apply -f rpcserver.yml` to run rpcserver in minikube.
12. Run `kubectl apply -f rpccclient.yml` to run rpcclient in minikube.
13. Run `kubectl apply -f rpc-server-service.yml` to create a Service for rpcserver.
14. Run `kubectl apply -f rpc-client-service.yml` to create a Service for rpcclient.
15. Run `docker build -t my-prometheus .` to build a prometheus image.
16. Run `kubectl apply -f prometheus.yml` to run a prometheus in minikube.
17. Run `kubectl expose deployment rpc-client-deployment --type=NodePort && minikube service rpc-client-deployment --url` to get the URL of rpcclient, than you can visit http://192.168.99.100:30304/hello (Please change the ip and port according to the result of command above.)
18. Run `kubectl expose deployment prometheus-deployment --type=NodePort && minikube service prometheus-deployment --url` to get the address of prometheus, than you can visit prometheus via the address.
19. Run `kubectl expose deployment zikpin-deployment --type=NodePort && minikube service zikpin-deployment --url` to get the address of zipkin, than you can visit zipkin via the address.