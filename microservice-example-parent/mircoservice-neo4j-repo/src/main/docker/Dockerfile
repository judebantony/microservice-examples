FROM java:8-jre
VOLUME /tmp
ADD mircoservice-neo4j-repo.jar mircoservice-neo4j-repo.jar
RUN sh -c 'touch /mircoservice-neo4j-repo.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /mircoservice-neo4j-repo.jar" ]

EXPOSE 18080