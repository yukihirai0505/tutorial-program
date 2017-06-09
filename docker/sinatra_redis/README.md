## Docker

```
$ docker-machine create --driver virtualbox sinatraredis
$ docker-compose run web rails new . --force --database=postgresql --skip-bundle
$ eval $(docker-machine env sinatraredis)
$ docker-compose up -d
```