package de.kisner.test.eap.client;

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

	public void find()
	{
		logger.info(fUtils.find(SecurityMenu.class,1l).toString());
		logger.info(fUtils.find(SecurityMenu.class,2l).toString());
	}
	
	public static void main(String[] args) throws NamingException
	{
		EapBootstrap.init();
		TestSecurityMenu test =  new TestSecurityMenu();
		
		test.find();
	}
}