FROM java:8-jre
VOLUME /tmp
ADD microservice-service-registry.jar microservice-service-registry.jar
RUN sh -c 'touch /travel-portel-registry.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-service-registry.jar" ]

EXPOSE 9090