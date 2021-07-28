# Musala Task

This sample project is managing gateways - master devices that control multiple peripheral devices.

And basically you will found all the implemented apis in the openapi.swagger contract file and the expected responses ( to make it more readable take the openapi.yaml in swagger editor ;)

## Technologies
this project using mainly Java JDK 8 , spring boot , openapi 3 for swagger contract , spring data (jpa)  , and in-memory database (h2).

## Installation

pull the code and run the project on any IDE (i am using intellij) using the embedded Tomcat server of spring boot.

```bash
git clone https://github.com/hanan-ayman/MusalaTask.git
```

## Usage
1- you can add into the in-memory database h2 using the scripts running into console (you will found the scripts (data.sql) into resources folder)
```bash
http://localhost:8080/h2/
```
2- also , you can use postman requests to manipulate with the database (you will found the postman requests(postmanTestCases.json) into resources folder also ;) 

