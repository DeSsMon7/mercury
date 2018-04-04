package com.ash.mercury.customer.control;

import com.ash.mercury.customer.model.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Timmy
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "com.ash_mercury_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    public List findCustomerId() {
        return em.createQuery("SELECT c FROM Customer c")
                .getResultList();
    }

    public List<Customer> findAllCustomer() {
        return em.createQuery("SELECT c FROM Customer c")
                .getResultList();
    }

}
