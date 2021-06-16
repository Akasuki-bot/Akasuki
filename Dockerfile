FROM openjdk:11.0.9-oracle

ADD activities.json /app/
ADD pom.xml /app/
ADD /target /app/

WORKDIR /app

CMD ["/bin/sh"]