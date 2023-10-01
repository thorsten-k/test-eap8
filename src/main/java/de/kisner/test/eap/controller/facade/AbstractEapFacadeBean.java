package de.kisner.test.eap.controller.facade;

import org.jeesl.controller.facade.jk.AbstractJeeslFacadeBean;
import org.jeesl.controller.facade.jk.JeeslFacadeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.test.eap.interfaces.repository.EapRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class AbstractEapFacadeBean extends AbstractJeeslFacadeBean
{
	final static Logger logger = LoggerFactory.getLogger(AbstractEapFacadeBean.class);
	
	static final long serialVersionUID=10;
	
    @Inject @EapRepository
    protected EntityManager em;
    
    @PostConstruct
    public void initUtilsFacade()
    {
    	fJeesl = new JeeslFacadeBean(em);
    }

}