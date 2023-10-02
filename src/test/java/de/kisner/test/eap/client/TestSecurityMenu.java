package de.kisner.test.eap.client;

import java.util.concurrent.TimeUnit;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.test.eap.facade.EapFacade;
import de.kisner.test.eap.model.SecurityMenu;

public class TestSecurityMenu
{
	final static Logger logger = LoggerFactory.getLogger(TestSecurityMenu.class);

	private final EapFacade fUtils;

	private TestSecurityMenu() throws NamingException
	{
		fUtils = EapBootstrap.lookup(EapFacade.class);
	}

	public void find() throws InterruptedException
	{
//		TimeUnit.SECONDS.sleep(2);
//		logger.info("Finding 1");
//		logger.info(fUtils.find(SecurityMenu.class,1l).toString());
		
		TimeUnit.SECONDS.sleep(2);
		logger.info("Finding 2");
		logger.info(fUtils.find(SecurityMenu.class,2l).toString());
	}
	
	public static void main(String[] args) throws NamingException, InterruptedException
	{
		EapBootstrap.init();
		TestSecurityMenu test =  new TestSecurityMenu();
		
		test.find();
	}
}