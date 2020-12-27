FROM openjdk:12-jdk-alpine
RUN addgroup -S dev && adduser -S irving -G dev
USER irving:dev
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.RestAPI.SpringBootRestApiApplication"]