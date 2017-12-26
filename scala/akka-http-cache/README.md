## Run application
To run application, call:
```
sbt run
```
If you wanna restart your application without reloading of sbt, use:
```
sbt re-start
```

## Run tests
To run tests, call:
```
sbt test
```

## Make standalone jar
To make standalone jar file
```
sbt clean assembly
```

without test

```
sbt 'set test in assembly := {}' clean assembly
```

To run it

```
java -jar api-standalone.jar
```