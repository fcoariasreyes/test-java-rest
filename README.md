## TEST REST - Ejemplo 

Autor: Francisco Arias Reyes

Este ejemplo contempla las siguientes tecnologías 

- Swagger 2.0 Integration
- Swagger CodeGen Integration
- Testing services
- Testing controllers
- HSQL Memory Database
- Hibernate


### Clase controlador

AppBoot.java -- Package cl.test.tbk.fcoarias

### Ejección

```
brew install maven
mvn spring-boot:run
```

### Swager integración 

- http://localhost:8080/v2/api-docs
- http://localhost:8080/swagger-ui.html

### Ejecutar todos los test

```
mvn test
```

### Ejecutar swager

```
brew install swagger-codegen
./generate-client.sh
```

`generate-client.sh` outputs Java source code into ./client directory and does `mvn install`.
 

