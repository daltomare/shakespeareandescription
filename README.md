# Getting Started

### Solution description
This is a simple application showing how to complete the https://docs.google.com/document/d/1L0xflPoRq2fbPH0vK9--FGUVyny5LjTCwh-Cki41Xps/edit# test.

The architecture is based on a very simplified version of CleanCode architectures (https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

UseCase / Interactors embed business logic.

In the application is present only one interactor "GetShakespeareanDescriptionUseCase" fulfilling the logic of the exercise.

The interactor has been implemented using TDD approach (GetShakespeareanDescriptionTest in package unit tests), only one test case is present but further ones could be potentially added to manage special scenarios (for example management of non existing pokemon).

Gateways toward external systems (FunTranslationAPIAdapter, PokeAPIAdapter) are injected in the interactor using Dependency Injection (this is a Spring Boot application, so the DI framework is Spring).

Given this is an exercise, logic of the implementation of the gateways is stubbed (so there is not real access to the API, but this could be easily implemented if needed).

A REST controller (GetShakespeareanDescriptionController)  handles the REST request, dispatches it to the interactor and returns the results.

The GetShakespeareanDescriptionTest in the integration package, tests the integration of the use case across the layers.

The application is a Spring Boot application and has been packaged using Docker.

### How to run the application

In the application home directory:

./mvnw package

docker build -t truelayer/pokemons .

docker run -p 8080:8080 -t truelayer/pokemons

curl http://localhost:8080/pokemon/shiraz

### How to run the tests  

In the application home directory:

./mvnw clean

./mvnw test

This will run both unit and integration tests.


