FROM java:8

VOLUME /tmp

ADD target/monitoring*.jar monitoring.jar

RUN bash -c 'touch /monitoring.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/monitoring.jar"]
