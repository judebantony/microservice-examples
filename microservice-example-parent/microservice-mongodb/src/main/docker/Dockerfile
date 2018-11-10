FROM java:8-jre
VOLUME /tmp
ADD microservice-mongodb.jar microservice-mongodb.jar
RUN sh -c 'touch /microservice-mongodb'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-mongodb.jar" ]

EXPOSE 17070