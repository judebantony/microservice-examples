FROM java:8-jre
VOLUME /tmp
ADD microservice-zipkin-stream-server.jar microservice-zipkin-stream-server.jar
RUN sh -c 'touch /microservice-zipkin-stream-server.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-zipkin-stream-server.jar" ]

EXPOSE 4483