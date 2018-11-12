FROM java:8-jre
VOLUME /tmp
ADD microservice-config-server.jar microservice-config-server.jar
RUN sh -c 'touch /microservice-config-server.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-config-server.jar" ]

EXPOSE 7070