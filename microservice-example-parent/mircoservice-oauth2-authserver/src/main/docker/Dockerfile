FROM java:8-jre
VOLUME /tmp
ADD mircoservice-oauth2-authserver.jar mircoservice-oauth2-authserver.jar
RUN sh -c 'touch /mircoservice-oauth2-authserver.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /mircoservice-oauth2-authserver.jar" ]

EXPOSE 8443