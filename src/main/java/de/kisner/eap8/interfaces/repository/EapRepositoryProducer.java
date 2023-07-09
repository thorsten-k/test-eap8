package de.kisner.eap8.interfaces.repository;

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
