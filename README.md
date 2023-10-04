# Demo WAR for EAP-8 deployments


- Create a PostgreSQL (15 or 16) database, a script is available here: /test-eap/src/main/resources/sql/eapInit.sh, the relevant SQL statements are

		CREATE USER eap WITH PASSWORD 'eap';
		CREATE DATABASE eap OWNER eap ENCODING 'UTF8';

- Download EAP 8.0 Beta (https://developers.redhat.com/products/eap/download)
- Start EAP with bin/standalone.sh -c standalone-ha.xml
- Configure JBoss EAP (please replace the path to the postgresql.jar with your settings), then execute bin/jboss-cli.sh -c

		module add --name=org.postgresql.jdbc --resources=/Users/thorsten/.m2/repository/org/postgresql/postgresql/42.6.0/postgresql-42.6.0.jar --dependencies=javax.api,javax.transaction.api
		/subsystem=datasources/jdbc-driver=postgresql:add(driver-name="postgresql",driver-module-name="org.postgresql.jdbc",driver-class-name=org.postgresql.Driver)
		data-source add --jndi-name=java:jboss/datasources/EapDs --name=EapDs --connection-url=jdbc:postgresql://localhost:30016/eap --driver-name=postgresql --user-name=eap --password=eap
		
- Stop Jboss, open standalone-ha.xml and the add the statement section for the DataStore definition in standalone.xml

		<datasource jndi-name="java:jboss/datasources/EapDs" ...>
			<statement>
				<prepared-statement-cache-size>32</prepared-statement-cache-size>
				<share-prepared-statements>true</share-prepared-statements>
			</statement>
		</datasource>
    
- Start Jboss and deploy the test WAR  mvn wildfly:deploy 
- The database will be populated with values

		INSERT INTO SecurityView (id,code) VALUES (1,'settings')
		INSERT INTO SecurityView (id,code) VALUES (2,'settingsSystem')
		INSERT INTO SecurityMenu (id,view_id,parent_id) VALUES (1,1,NULL)
		INSERT INTO SecurityMenu (id,view_id,parent_id) VALUES (2,2,1)

- Execute TestSecurityMenu, this will try to retrieve the SecurityMenu entry with id=2

- You will geth the error

		HHH000327: Error performing load command: org.hibernate.sql.exec.ExecutionException:
		A problem occurred in the SQL executor : Error advancing (next) ResultSet position
    
- Stop JBoss, remove the statement-section in the datasource, start JBoss and try again.