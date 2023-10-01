package de.kisner.test.eap.model.ejb.system.security;

import java.util.List;
import java.util.Objects;

import javax.naming.NamingException;

import org.apache.commons.configuration2.Configuration;
import org.jeesl.api.facade.JeeslFacadeLookup;
import org.jeesl.controller.monitoring.counter.ProcessingTimeTracker;
import org.jeesl.exception.ejb.JeeslNotFoundException;
import org.jeesl.model.ejb.system.security.context.SecurityMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.test.eap.client.EapBootstrap;
import de.kisner.test.eap.interfaces.facade.EapUtilsFacade;

public class CliSecurityMenu
{
	final static Logger logger = LoggerFactory.getLogger(CliSecurityMenu.class);

	private final EapUtilsFacade fUtils;

	private CliSecurityMenu(JeeslFacadeLookup jfl) throws NamingException
	{
		fUtils = jfl.lookup(EapUtilsFacade.class);
	}

	public void find() throws JeeslNotFoundException
	{
		ProcessingTimeTracker ptt = ProcessingTimeTracker.instance().start();
		SecurityMenu m = fUtils.find(SecurityMenu.class,2);
		logger.info(ptt.toTotalPeriod()+" "+m.toString());
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
		CliSecurityMenu test =  new CliSecurityMenu(EapBootstrap.facadeLookup(config));
		
//		test.find();
		test.list();
	}
}