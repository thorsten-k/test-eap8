# Demo WAR for EAP-8 deployments
Testing WAR release on EAP8

## Compiling
EAP-8 requires Java 11, project settings are defined, but command line needs to be adjusted.

- MacOS

		/usr/libexec/java_home -V
		export JAVA_HOME=$(/usr/libexec/java_home -v11.0.14)

## Web Resources

- https://www.wildfly.org/news/2022/11/09/WildFly27-Final-Released/
- http://www.mastertheboss.com/java-ee/jakarta-ee/jakarta-ee-10-is-on-its-way-with-wildfly-27/
- http://www.mastertheboss.com/jbossas/jboss-eap/what-is-the-difference-between-jboss-eap-wildfly-and-jboss-as/

## ToDo

1. Check versions of web.xml
2. Check versions of beans.xml
3. Check versions of faces-config.xml
4. Check forwarding of index.html

## Working on ... persistence.xml

- JPA: jakarta.persistence:jakarta.persistence-api:3.1.0

With jboss-cli.sh


		module add --name=org.postgresql.jdbc --resources=/Users/thorsten/.m2/repository/org/postgresql/postgresql/42.6.0/postgresql-42.6.0.jar --dependencies=javax.api,javax.transaction.api
		/subsystem=datasources/jdbc-driver=postgresql:add(driver-name="postgresql",driver-module-name="org.postgresql.jdbc",driver-class-name=org.postgresql.Driver)
		data-source add --jndi-name=java:/Eap8Ds --name=Eap8Ds --connection-url=jdbc:postgresql://localhost:30015/eap8 --driver-name=postgresql --user-name=eap8 --password=jswnevkjnwEGKJNSKIAJNEV
		
- add org.postgresql in hibernate/module.xml



## Migration Guide

### pom.xml

- wildfly-maven-plugin to 4.0.0.Final
- maven-compiler-plugin to 3.10.1
- maven-war-plugin to 3.3.2
- JPA: jakarta.persistence:jakarta.persistence-api:3.1.0


