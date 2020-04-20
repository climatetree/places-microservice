# Backend [Places-Microservice-Server]
[![Build Status](https://travis-ci.com/climatetree/places-microservice.svg?branch=develop)](https://travis-ci.com/climatetree/places-microservice)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.climatetree%3Aplaces-microservice&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.climatetree%3Aplaces-microservice)

# Microservice Architecture
## Repo Structure
This repository holds the source code for the backend services for locations/places included included the 
climateTree.wiki web application. This application was built using Java, Maven, and Spring Boot.
This repo contains the following important folders:
- Controller
    - Hosts the API endpoints
- Dao
    - Provides queries that can be called on the connected database.
    - All queries return a GeoJson object string.
- Services
    - Intermediary class between the Controller and the Dao that performs additional data processing 
      steps.

The Model and DTO folders are not currently in use, but were kept for archiving purposes. 

## API Endpoints
It is important to note that only 1 of the 4 APIs is currently being used in the climateTree.wiki project. The
only API that is being used is `/api/v1/places/{name}`. This is being used by the front end to retrieve the names
of places that contain the given `name`. All other APIs have been transition to GeoServer. The GeoServer repository 
can be viewed [here](https://github.com/climatetree/geoserver-docker).

The endpoints that are defined in the Controller can be viewed [here on Postman](https://documenter.getpostman.com/view/10295047/Szf55VXU?version=latest)

## Database
This application directly connects to the ClimateTree project's Places Database that is currently hosted
on Azure. Connection strings are provided as environment variables to the `application.properties` configuration. The
database schema can be seen [here](https://tinyurl.com/yaa3rfp3).

## Bugs, Enhancements, and Improvements



    
