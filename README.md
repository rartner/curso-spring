# Curso Spring

Web application using Spring Boot.

## Requirements

- JDK8

- Maven 3.3.9

## Build

```bash
> mvn install
```

## Run

```bash
> mvn spring-boot:run
```

or

```bash
> java -jar target/curso-0.0.1-SNAPSHOT.jar
```

## Resources

Database will run at: `http://localhost:8096/h2`

Connect to database using:

- JDBC URL: `jdbc:h2:file:~/curso`

- User: `sa`

- Password: ``

Swagger will run at: `http://localhost:8096/swagger-ui.html`