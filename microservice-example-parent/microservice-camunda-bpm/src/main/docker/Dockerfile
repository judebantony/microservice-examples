FROM java:8-jre
VOLUME /tmp
ADD microservice-camunda-bpm.jar microservice-camunda-bpm.jar
RUN sh -c 'touch /microservice-camunda-bpm.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-camunda-bpm.jar" ]

EXPOSE 2070