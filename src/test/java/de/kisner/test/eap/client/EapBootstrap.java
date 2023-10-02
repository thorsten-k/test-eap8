package de.kisner.test.eap.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.configuration2.Configuration;
import org.jeesl.api.facade.JeeslFacadeLookup;
import org.jeesl.controller.facade.lookup.JeeslEap71FacadeLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.test.eap.facade.EapFacade;
import net.sf.exlp.exception.ExlpConfigurationException;
import net.sf.exlp.util.config.ConfigLoader;
import net.sf.exlp.util.io.ExlpCentralConfigPointer;
import net.sf.exlp.util.io.LoggerInit;
import net.sf.exlp.util.xml.jk.JaxbUtil;

public class EapBootstrap
{
	final static Logger logger = LoggerFactory.getLogger(EapBootstrap.class);
	public final static String xmlConfig = "test-eap/system/property/eap.xml";

	private static Configuration config;

	public static String cfgDbDs = "db.jeesl.ds";
	public static String cfgDbHost = "db.jeesl.host";
	public static String cfgDbName = "db.jeesl.db";
	public static String cfgDbUser = "db.jeesl.user";
	public static String cfgDbPwd = "db.jeesl.pwd";
	public final static String jeeslRest = "net.rest.url.local";

	public static Configuration init()
	{
		return init(xmlConfig);
	}

	public static Configuration init(String configFile)
	{
//		LoggerInit loggerInit = new LoggerInit("log4j.xml");
//		loggerInit.addAltPath("jeesl/showcase/config");
//		loggerInit.init();
//		JaxbUtil.setNsPrefixMapper(new JeeslNsPrefixMapper());

		ConfigLoader cl = ConfigLoader.instance();
		try
		{
			ExlpCentralConfigPointer ccp = ExlpCentralConfigPointer.instance(EapFacade.IoSsiSystemCode.eap).jaxb(JaxbUtil.instance());
			cl.add(ccp.toFile("client").toPath());
		}
		catch (ExlpConfigurationException e) {logger.debug("No additional "+ExlpCentralConfigPointer.class.getSimpleName()+" "+e.getMessage());}
		cl.addS(xmlConfig);
		
		config = cl.combine();

		logger.debug("Config and Logger initialized");
		return config;
	}


	public static JeeslFacadeLookup facadeLookup(Configuration config)
	{
		JeeslEap71FacadeLookup eap71Lookup = new JeeslEap71FacadeLookup("eap");
		return eap71Lookup;
	}

	@SuppressWarnings("unchecked")
	public static <F> F lookup(Class<F> facade) throws NamingException
	{
		Context context = buildContext();
		
		StringBuilder sb = new StringBuilder();
		sb.append("ejb:");
		sb.append("/eap");
		sb.append("/").append(facade.getSimpleName()).append("Bean");
		sb.append("!").append(facade.getName());	
		logger.info("Looking up: "+sb.toString());
		
		return (F)context.lookup(sb.toString());
	}
	
	private static Context buildContext() throws NamingException
	{
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,  "org.wildfly.naming.client.WildFlyInitialContextFactory");
		properties.put(Context.PROVIDER_URL, String.format("%s://%s:%d", "remote+http", "localhost", 8080));
		properties.put("jboss.naming.client.ejb.context", true);
		
		return new InitialContext(properties);
	}
}