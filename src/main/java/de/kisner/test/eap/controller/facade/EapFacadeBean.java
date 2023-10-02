package de.kisner.test.eap.controller.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.test.eap.interfaces.facade.EapFacade;
import de.kisner.test.eap.interfaces.repository.EapRepository;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Stateless
@Remote(EapFacade.class)
public class EapFacadeBean implements EapFacade
{
	final static Logger logger = LoggerFactory.getLogger(EapFacadeBean.class);
	
	static final long serialVersionUID=10;
	
    @Inject @EapRepository
    protected EntityManager em;
    
    @Override public <T extends Object> T find(Class<T> type, long id)
	{
		T o = em.find(type,id);
		return o;
	}
    
    @Override public <T extends Object> List<T> all(Class<T> type)
	{
		CriteriaBuilder cB = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cB.createQuery(type);
		Root<T> from = criteriaQuery.from(type);

		CriteriaQuery<T> select = criteriaQuery.select(from);
		TypedQuery<T> typedQuery = em.createQuery(select);

		return typedQuery.getResultList();
	}
}