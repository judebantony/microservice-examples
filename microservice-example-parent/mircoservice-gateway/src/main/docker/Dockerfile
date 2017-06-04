FROM java:8-jre
VOLUME /tmp
ADD mircoservice-gateway.jar mircoservice-gateway.jar
RUN sh -c 'touch /mircoservice-gateway.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /mircoservice-gateway.jar" ]

EXPOSE 8888