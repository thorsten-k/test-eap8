package de.kisner.test.eap.web.mbean.controller.util;

import java.io.Serializable;
import java.util.Objects;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.EJBException;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;

@Singleton
@Startup
@TransactionManagement(value=TransactionManagementType.BEAN)
public class EapFlyway implements Serializable
{
	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(EapFlyway.class);
	
	@Resource(lookup="java:jboss/datasources/EapDs")
    private javax.sql.DataSource dataSource;
	
	@PostConstruct
	public void onStartup()
	{
		if(Objects.isNull(dataSource))
		{
			String error = "No datasource found to execute the db migrations!";
			logger.error(error);
			throw new EJBException(error);
		}
		else
		{
			Flyway flyway = Flyway.configure()
	        		.dataSource(dataSource)
	        		.table("iodbflyway")
	        		.locations("classpath:"+"test-eap/system/io/db/flyway")
	        		.sqlMigrationSeparator("-")
	        		.validateMigrationNaming(true)
	        		.baselineVersion("0.1.3")
	        		.baselineDescription("Baseline")
	        		.load();
			
	        MigrationInfo info = flyway.info().current();
	        if (Objects.isNull(info))
	        {
	        	logger.info("No Migration Info");
	        }
	        else
	        {
	        	logger.info("Found a database with the version: "+info.getVersion()+" : "+info.getDescription());
	        }
	        
	        flyway.baseline();
	        flyway.migrate();
		}
	 }
}