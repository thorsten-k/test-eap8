package de.kisner.test.eap.controller.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.test.eap.interfaces.facade.EapUtilsFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

@Stateless
@Remote(EapUtilsFacade.class)
public class EapUtilsFacadeBean extends AbstractEapFacadeBean implements EapUtilsFacade
{
	private final static Logger logger = LoggerFactory.getLogger(EapUtilsFacadeBean.class);
	static final long serialVersionUID=1;
	
    @PostConstruct
    public void postConstructJeesl()
    {
//    	ProcessingTimeTracker ptt = ProcessingTimeTracker.instance().start();
    	    	
    	
//		logger.info("@PostConstruct in "+ptt.toTotalPeriod());
    	logger.info("@PostConstruct");
    }
    
	
  
}