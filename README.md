# WEB API to manage a local product store

### Introduction
Morocco is one of the rich countries in terms of culture and traditions.
until now, Moroccans still cling to their heritage and traditional crafts 
in several fields, such as pottery, carpets, clothing, decoration, tiles and food.

For that reason, we have thinking about creating a small application that may help
our craftsmen to digitalizes the art they create every single minute.

### Requirements
The scenario of the application is as follows: 

- The Traditional crafts are managed not by the craftsmen themselves.
- Some associations/cooperatives are responsible for collecting the products and advertise it.
- Each cooperative can exist in different regions within morocco.
- Many categories of products: pottery, carpets, clothing, decoration, tiles, food...
- Product consist of one or more raw materials
- The same raw material can comes from different origins
- Client Can create account and start adding items to his cart
- Manage the shopping Cart (create, add/delete items, pay...)

### Technologies
- Java, openJDK 17
- [Spring Boot](https://spring.io/projects/spring-boot) framework 
to create the Rest API.
- [Spring Security](https://spring.io/projects/spring-security) to manage authentication and authorization 
- [JWT](https://jwt.io/) to allow a stateless connection to the server.
- JPA specification that provide interfaces and annotations to persist data
- [Hibernate](https://hibernate.org/) as ORM framework and implementation of JPA
- [MySQL](https://www.mysql.com/) database running in a [docker container](https://www.docker.com/resources/what-container/)

### Architecture 
A Monolithic architecture is used, with the next packages:
- **controllers:** the web layer where all the endpoints are defined
- **entities:** the persistent models .
- **repositories:** JPA interfaces to communicate to Database
- **services:** business layer
- **dto:** as best practice to not deal directly with the models, create DTOs so the client can interact with.
- **mappers:** it maps / converts an entity to DTO or inverse.
- **helpers:** contain a set of combinator handlers to check inputs validation
- **security:** the security layer responsible for authentication and authorization
- **exceptions:** contains a set of global exceptions that may occur at runtime.

### MySQL Database
MySQL database is running in docker container
1. Ensure that docker already installed, otherwise check [documentation](https://docs.docker.com/engine/install/)
    ```docker
    docker --version   
    ```
2. install MySQL 8.1.0 
    ```docker
    docker pull mysql:8.1.0   
    ```
3. Run MySQL container
    ```docker
    docker run -d -p 3306:3306 --name mysql-DB -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=local-products mysql:8.1.0
    ```
4. Interact with your container
    ```docker
    docker exec -it mysql-DB /bin/sh 
    ```
5. Once you inside the Container
    ```mysql
    mysql -u root -p local-product
    ```
6. you will be asked to provide your password
    ```mysql
    password> password
    ```
7. you are good to GO  👍👍

