# springb-easy-notes-app
The node-easy-notes-app reimplemented in Spring Boot / Kotlin for CDC testing using Pact.

## Reference documentation
* [_Building a REST Service with Kotlin, Spring Boot, MongoDB, and JUnit_ by Richard Wolniewicz](https://medium.com/@rhwolniewicz/building-a-rest-service-with-kotlin-spring-boot-mongodb-and-junit-14d10faa594b)
* [_Spring Data MongoDB - Reference Documentation_](https://docs.spring.io/spring-data/data-mongo/docs/1.7.0.M1/reference/html/)
* [_Pact Implementation Guide - Javascript_](https://docs.pact.io/implementation_guides/javascript)
* [_Pact Implementation Guide - JVM_](https://docs.pact.io/implementation_guides/jvm)

## Objectives
We have created a consumer / client library as part of a client app
([node-easy-notes-client](https://github.com/iris-yue-wang/node-easy-notes-client))
and written Pact tests for it that have created a Pactfile. This file, which has been published
to a Pact Broker
as well as being checked in as part of the project, defines the expected services offered
by the server supporting it in terms of a series of "interactions" in specified server states.

The [node-easy-notes-app](https://github.com/iris-yue-wang/node-easy-notes-app) provides
the server counterpart of this client/server application.
It has been tested using the Pactfile and this has verified that the REST protocol between
the client and server parts is consistent and usable, as well as the server implementation.

We now want to mimic the situation in which a separate implementation team has to build
a service to conform to the requirements expressed in a Pactfile - using a real-world tool
kit such as Spring Boot.

