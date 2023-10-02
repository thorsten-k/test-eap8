package de.kisner.test.eap.client;

import java.util.List;
import java.util.Objects;

import javax.naming.NamingException;

import org.apache.commons.configuration2.Configuration;
import org.jeesl.api.facade.JeeslFacadeLookup;
import org.jeesl.exception.ejb.JeeslNotFoundException;
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

	public void find() throws JeeslNotFoundException
	{
	
		SecurityMenu m = fUtils.find(SecurityMenu.class,2l);
	}
	
	public void list() throws JeeslNotFoundException
	{
		List<SecurityMenu> list = fUtils.all(SecurityMenu.class);
		logger.info(SecurityMenu.class.getSimpleName()+": "+list.size());
		
		for(SecurityMenu m : list)
		{
			System.out.println(m.toString()+" "+m.getView().getCode());
			if(Objects.isNull(m.getParent())) {logger.info(m.toString()+" "+m.getView().getCode());}
			SecurityMenu x = fUtils.find(SecurityMenu.class,m.getId());
//			try {TimeUnit.SECONDS.sleep(10);} catch (InterruptedException e) {}
		}
	}

	public static void main(String[] args) throws NamingException, JeeslNotFoundException
	{
		Configuration config = EapBootstrap.init();
		TestSecurityMenu test =  new TestSecurityMenu();
		
		test.find();
//		test.list();
	}
}