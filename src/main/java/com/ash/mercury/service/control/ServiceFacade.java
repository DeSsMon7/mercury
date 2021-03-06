package com.ash.mercury.service.control;

import com.ash.mercury.customer.control.AbstractFacade;
import com.ash.mercury.service.model.Service;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Timmy
 */
@Stateless
public class ServiceFacade extends AbstractFacade<Service> {

    @PersistenceContext(unitName = "com.ash_mercury_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceFacade() {
        super(Service.class);
    }
    
}
