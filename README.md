# relative-classpath-issue

This reposistory contains code to reproduce a bug in which the JVM fails to locate files on the classpath when the classpath contains `/../`.

There are three files in this project:
- run.sh
- Dockerfile
- Dockerfile-working

`run.sh` creates a simple java program, compiles it and then executes it. The compiled output gets put in a folder called `target` and the 
java command is invoked like so:
`java -classpath target/../target/ Main`

`Dockerfile` uses `adoptopenjdk/openjdk8:alpine-slim` as it's base image, copies over `run.sh` and executes it.

## Expected behaviour:
```bash
$ docker run -it $(docker build . | awk '/Success/{ print $3 }')
Hello world!
```

## Actual behaviour:
```bash
$ docker run -it $(docker build . | awk '/Success/{ print $3 }')
Error: Could not find or load main class Main
```

`Dockerfile-working` uses `adoptopenjdk/openjdk8:jdk8u282-b08-alpine-slim` as it's base image and does not behave the same. Using this image the program successfully executes.
