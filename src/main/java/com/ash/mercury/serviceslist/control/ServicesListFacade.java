/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ash.mercury.serviceslist.control;

import com.ash.mercury.customer.control.AbstractFacade;
import com.ash.mercury.serviceslist.model.ServicesList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Timmy
 */
@Stateless
public class ServicesListFacade extends AbstractFacade<ServicesList> {

    @PersistenceContext(unitName = "com.ash_mercury_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicesListFacade() {
        super(ServicesList.class);
    }
    
    public void insertService(ServicesList sl){
        em.createNativeQuery("INSERT INTO services_list(service_id, service_price , office_order_id) VALUES ( ?1, ?2, ?3)")
                .setParameter(1, sl.getServiceId())
                .setParameter(2, sl.getServicePrice())
                .setParameter(3, sl.getOfficeOrderId())
                .executeUpdate();
    
    }
    
}
