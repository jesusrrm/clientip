
./gradlew bootBuildImage --imageName=ghcr.io/jesusrrm/dynamic-ip:latest


docker run -it --rm \
-v ./build/libs:/tmp \
--entrypoint /bin/bash ghcr.io/graalvm/native-image-community:21 \
-c "java -version"