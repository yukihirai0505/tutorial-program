## Docker

```
$ docker-machine create --driver virtualbox rails
$ docker-compose run web rails new . --force --database=postgresql --skip-bundle
$ eval $(docker-machine env rails)
$ docker-compose up -d
```