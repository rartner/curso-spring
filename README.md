# curso-spring
Web application using Spring Boot.

## requirements
* JDK8
* Maven 3.3.9

## build
```bash
> mvn install
```

## run
```bash
> mvn spring-boot:run
```
or
```bash
> java -jar target/curso-0.0.1-SNAPSHOT.jar
```

## database
Database will run at: http://localhost:8096/h2

Connect to database using:
* JDBC URL: jdbc:h2:file:~/curso
* User: sa
* Password: