FROM tomcat:9.0

# remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# copy your WAR file
COPY auth_cred_project.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]