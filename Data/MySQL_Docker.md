DockerHub: https://hub.docker.com/_/mysql


# Docker Command


Get the lasts mysql image

```shell
docker pull mysql
```

Run the mysql instrance

```
docker run --name shop.mysql -p 3306:3308 -e MYSQL_ROOT_PASSWORD=0418 -d mysql
```

We have run a mysql instrance and from the virtual mysql map network to the local network port. Now it is runing, you can use the local mysql user client interface connecting the docker mysql instrance



