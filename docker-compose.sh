#!/bin/sh

MAIN_MODULE_IMAGE_ID=$(docker images -aq demo-tests_main-module)
if [[ ! -z "${MAIN_MODULE_IMAGE_ID}" ]]; then
  echo "Removing previously MAIN_MODULE_IMAGE with id: ${MAIN_MODULE_IMAGE_ID}"
  docker rm $(docker rmi -f ${MAIN_MODULE_IMAGE_ID})
fi

echo "Building project"
./gradlew clean build

echo "Starting Docker Compose"
docker-compose up