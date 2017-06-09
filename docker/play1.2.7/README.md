## Docker

```
$ docker-machine create --driver virtualbox play1.2.7
$ eval $(docker-machine env play1.2.7)
# or echo "eval \$(docker-machine env play1.2.7)" > .envrc && direnv allow
$ docker-compose up -d
```

## See container

```
$ docker run -it play127_web /bin/bash
```