FROM java:8
MAINTAINER Jyong <yuki-nami@hotmail.com>

ENV JAVA_OPTS "-Dspring.profiles.active=production"

VOLUME /tmp
ADD hithinksoft-hompage-*.jar app.jar
RUN sh -c 'touch /app.jar'

ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
