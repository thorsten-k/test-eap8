# Demo WAR for EAP-8 deployments
Testing WAR release on EAP8

## Compiling
EAP-8 requires Java 11, project settings are defined, but command line needs to be adjusted.

- MacOS

		/usr/libexec/java_home -V
		export JAVA_HOME=$(/usr/libexec/java_home -v11.0.17)

## ToDo

1. Check versions of web.xml
2. Check versions of beans.xml
3. Check versions of faces-config.xml
4. Check forwarding of index.html

## Working on ... persistence.xml

- JPA: jakarta.persistence:jakarta.persistence-api:3.1.0

With jboss-cli.sh

		module add --name=org.postgres --resources=postgresql-42.2.5.jar --dependencies=javax.api,javax.transaction.api
		/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)
		data-source add --jndi-name=java:/EapDs --name=EapDs --connection-url=jdbc:postgresql://localhost:30015/eap8 --driver-name=postgres --user-name=eap8 --password=jswnevkjnwEGKJNSKIAJNEV
		
Deployment without error, but table for DemoEntity is not created :-(

## Migration Guide

### pom.xml

- wildfly-maven-plugin to 4.0.0.Final
- maven-compiler-plugin to 3.10.1
- maven-war-plugin to 3.3.2
- JPA: jakarta.persistence:jakarta.persistence-api:3.1.0


