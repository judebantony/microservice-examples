FROM java:8-jre
VOLUME /tmp
ADD microservice-cassandra.jar microservice-cassandra.jar
RUN sh -c 'touch /microservice-cassandra.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-cassandra.jar" ]

EXPOSE 19090