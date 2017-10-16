/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ash.mercury.servicepart.control;

import com.ash.mercury.servicepart.model.ServicePart;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Timmy
 */
@Stateless
public class ServicePartFacade extends AbstractFacade<ServicePart> {

    @PersistenceContext(unitName = "com.ash_mercury_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicePartFacade() {
        super(ServicePart.class);
    }

    public void insertServicePart(ServicePart sp) {
        em.createNativeQuery("INSERT INTO service_parts( part_id , part_quantity , part_unit_price, part_total_price, office_order_id) VALUES (?1,?2,?3,?4,?5)")
                .setParameter(1, sp.getPartId())
                .setParameter(2, sp.getPartQuantity())
                .setParameter(3, sp.getPartUnitPrice())
                .setParameter(4, sp.getPartTotalPrice())
                .setParameter(5, sp.getOfficeOrderId())
                .executeUpdate();
    }
}
