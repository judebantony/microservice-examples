FROM java:8-jre
VOLUME /tmp
ADD microservice-feign-client.jar microservice-feign-client.jar
RUN sh -c 'touch /microservice-feign-client.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-feign-client.jar" ]

EXPOSE 3383