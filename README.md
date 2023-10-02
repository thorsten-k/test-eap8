# Demo WAR for EAP-8 deployments
Testing WAR release on EAP8

## Steps to Reproduce
- Download and start EAP8

## Configure JBoss EAP
- Replace the path to the postgresql.jar with your settings, then executre jboss-cli.sh -c

		module add --name=org.postgresql.jdbc --resources=/Users/thorsten/.m2/repository/org/postgresql/postgresql/42.6.0/postgresql-42.6.0.jar --dependencies=javax.api,javax.transaction.api
		/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgresql.jdbc",driver-class-name=org.postgresql.Driver)
		data-source add --jndi-name=java:jboss/datasources/EapDs --name=EapDs --connection-url=jdbc:postgresql://localhost:30016/eap --driver-name=postgres --user-name=eap --password=eap
		

