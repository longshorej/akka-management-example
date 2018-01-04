# akka-management-example

This project shows how you can configure [Akka Management](https://github.com/akka/akka-management), using its Kubernetes API,
to allow different Akka Cluster applications to join the same cluster.

Namely, these steps were done:

1) For each Deployment, Add a label of `actorSystemName` with value `my-system`.
2) Set `akka.discovery.method` to "kubernetes-api"
3) Set `akka.discovery.kubernetes-api.pod-label-selector` to "actorSystemName=%s" so that it finds pods with the label specified in #1.
