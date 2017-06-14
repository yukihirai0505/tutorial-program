## Docker

```
$ docker-machine create --driver virtualbox play1.2.7
$ eval $(docker-machine env play1.2.7)
# or echo "eval \$(docker-machine env play1.2.7)" > .envrc && direnv allow
$ docker-compose up -d
```

## Docker Tips


To confirm process

`$ docker ps`

Login to a running container

`$ docker exec -i -t {CONTAINER ID} /bin/bash`

Start container and login

`$ docker run -it play127_web /bin/bash`

