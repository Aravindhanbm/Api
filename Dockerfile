FROM gradle:8.4-jdk8
COPY src home/Api/src/test/resources
COPY build.gradle home/Api/build.gradle
COPY settings.gradle home/Api/settings.gradle
COPY logging.txt home/Api/logging.txt
COPY target home/Api/target
COPY File.property home/Api/src/test/resources/File.property
WORKDIR home/Api
ENTRYPOINT gradle test