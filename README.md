### Requisitos

- java 11
- maven
- docker

### intruccion para ejecutar el proyecto

En una terminal de unix ejecutar los siguientes comandos:

* `mvn clean`
* `mvn package`
* `docker-compose build`
* `docker-compose up -d`

Ya se pueden probar los servicios en el puerto 8081

endpoints:

GET
* `http://localhost:8081/v1.0/ticket/{page}/{size}`
* `http://localhost:8081/v1.0/ticket/{userId}/{page}/{size}`
* `http://localhost:8081/v1.0/ticket/{userId}/{status}/{page}/{size}`
* `http://localhost:8081/v1.0/ticket/{status}/{page}/{size}`
* `http://localhost:8081/v1.0/ticket/{creationDate}/{page}/{size}`
* `http://localhost:8081/v1.0/ticket/{creationDate}/{status}/{page}/{size}`
* `http://localhost:8081/v1.0/ticket/{dateBegin}/{dateEnd}/{page}/{size}`

POST
* `http://localhost:8081/v1.0/ticket`

PUT
* `http://localhost:8081/v1.0/ticket/{ticketId}`

DELETE
* `http://localhost:8081/v1.0/ticket/{ticketId}`

### instrucciones para ejecutar los test

En una terminal de unix ejecutar los siguientes comandos:

* `mvn clean`
* `mvn test`
