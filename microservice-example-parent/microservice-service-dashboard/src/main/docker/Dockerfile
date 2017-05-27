FROM java:8-jre
VOLUME /tmp
ADD microservice-service-dashboard.jar microservice-service-dashboard.jar
RUN sh -c 'touch /microservice-service-dashboard.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /microservice-service-dashboard.jar" ]

EXPOSE 9999