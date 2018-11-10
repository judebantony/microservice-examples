FROM java:8-jre
VOLUME /tmp
ADD microservice-elasticsearch.jar microservice-elasticsearch.jar
RUN sh -c 'touch /microservice-elasticsearch.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-elasticsearch.jar" ]

EXPOSE 19080