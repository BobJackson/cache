## Use springboot 3.0.0 + spring data jpa + spring data redis

### Runtime Env

* jdk 17+
* docker compose
* IntelliJ IDEA
* mac M2

### shell

````
1.docker-compose.yaml

version: "3"
services:
 db:
  restart: always
  command: --default-authentication-plugin=mysql_native_password
  container_name: mysql
  image: mysql/mysql-server:latest
  environment:
   MYSQL_ROOT_PASSWORD: 123456
  ports:
   - 3306:3306
  volumes:
   - ./data:/var/lib/mysql

2.docker-compose.yaml
version: '3'
services:
  redis:
    image: redis:5.0.0
    container_name: redis
    restart: always
    ports:
      - "6379:6379"
    volumes:
      - ./data:/data
````

### notes

when you can't access mysql, you can run the following commands:

````
docker exec -it mysql bash

## in container
mysql -u root -p 123456

## in mysql bash
CREATE USER 'root'@'%' IDENTIFIED BY 'root';
GRANT ALL ON *.* TO 'root'@'%';
flush privileges;
````
