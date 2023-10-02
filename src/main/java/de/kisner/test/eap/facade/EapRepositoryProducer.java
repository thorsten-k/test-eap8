package de.kisner.test.eap.facade;

import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class EapRepositoryProducer
{
    @Produces
    @EapRepository
    @PersistenceContext
    private EntityManager em;
}
