FROM java:8-jre
VOLUME /tmp
ADD microservice-websocket.jar microservice-websocket.jar
RUN sh -c 'touch /microservice-websocket.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-websocket.jar" ]

EXPOSE 4383