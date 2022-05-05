FROM adoptopenjdk/openjdk11

MAINTAINER Mauricio Generoso

RUN mkdir /apps

COPY ./build/libs/main-module.jar /apps

ENTRYPOINT exec java ${JAVA_OPTS} -jar /apps/main-module.jar