package de.kisner.eap8.config;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.OperationBuilder;
import org.jboss.as.controller.client.helpers.ClientConstants;
import org.jboss.dmr.ModelNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CliJbossModule
{
	final static Logger logger = LoggerFactory.getLogger(CliJbossModule.class);
	
	
	
	
	public CliJbossModule() throws UnknownHostException
	{
		ModelControllerClient client = ModelControllerClient.Factory.create(InetAddress.getByName("localhost"), 9990);
//		jbossStandalone = new JbossStandaloneConfigurator(client);
	}
	
	public void dsExists() throws IOException
	{
		ModelNode request = new ModelNode();
		request.get(ClientConstants.OP).set(ClientConstants.ADD);
		request.get(ClientConstants.OP_ADDR).add("module");
		request.get("name").set("org.postgres");
		request.get("resources").set("postgresql-42.2.5.jar");
		request.get("dependencies").set("javax.api,javax.transaction.api");
	
		ModelControllerClient client = ModelControllerClient.Factory.create(InetAddress.getByName("localhost"), 9990);
		client.execute(new OperationBuilder(request).build());
		logger.info("Completed");
		
//		boolean postgresExists = jbossStandalone.dsExists("postgres");
//		logger.info("dsExists: "+postgresExists);
//		if(!postgresExists)
//		{
//			jbossStandalone.createPostgresDriver();
//			logger.info("After Create: "+jbossStandalone.dsExists("postgres"));
//		}
//		client.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		
		CliJbossModule cli = new CliJbossModule();
		
		cli.dsExists();
	}
}