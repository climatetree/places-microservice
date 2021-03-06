#!/bin/bash
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker build -t climatetree-places .
docker tag climatetree-places patelvp/climatetree-places
docker push patelvp/climatetree-places