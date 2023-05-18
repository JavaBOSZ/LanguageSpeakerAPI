# Getting Started
### db
>docker-compose.yml
```yaml

# Use postgres/example user/password credentials
version: '3.1'

services:

  db:
    image: postgres:latest
    ports:
      - "5432:5432"
    restart: always
    environment:
      POSTGRES_PASSWORD: example
      POSTGRES_DB: dbls

```
Run 
```bash
docker stack deploy -c docker-compose.yml postgres 
```
or 
```bash
docker-compose -f docker-compose.yml up
```

### javaScript

> in src/front 
> ```bash
>   cd src/front
> ```

```bash
npm install
```

### java

> in main directory 
>```bash
>cd ../..
>```
```bash
mvn clean package
```
or
```bash
./mvnw clean package
```

```bash
java -jar target/LanguageSpeakerAPI-0.0.1-SNAPSHOT.jar
```
or 
> #### Run from IDE 
> main -> src/main/java/me/szydelko/languagespeakerapi/LanguageSpeakerApiApplication.java

### configuration

#### database configuration
> src/main/resources/application.yaml
```yaml
spring:
  jpa:
    database: POSTGRESQL
    show-sql: true
    hibernate:
      ddl-auto: create-drop
  datasource:
    url: jdbc:postgresql://localhost:5432/dbls
    username: postgres
    password: example
    driverClassName: org.postgresql.Driver
  sql:
    init:
      platform: postgres
```
#### if you want the databases don't DROP on the startup 
```yaml
spring:
  jpa:
      ddl-auto: update 
```
#### oauth2 configuration
> src/main/resources/application.yaml
```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          github:
            clientId: Iv1.7272d97770f79302
            clientSecret: ae2ddd54686e3bc0595c0d3c32c5e6223cda31e8
```

### Reference Documentation

Docker

* [docker postgres](https://hub.docker.com/_/postgres)


For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/#build-image)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.security.oauth2.client)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.security)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

