package com.ash.mercury.device.control;

import com.ash.mercury.customer.control.AbstractFacade;
import com.ash.mercury.device.model.Device;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Timmy
 */
@Stateless
public class DeviceFacade extends AbstractFacade<Device> {

    @PersistenceContext(unitName = "com.ash_mercury_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeviceFacade() {
        super(Device.class);
    }

    public List findDevices(Integer id) {
     return em.createQuery("SELECT d FROM Device d WHERE d.customerId.customerId = :customerId")
                .setParameter("customerId", id)
                .getResultList();
    }

    public List findByCustomerId(Integer id) {
        return em.createQuery("SELECT d FROM Device d WHERE d.customerId = :customerId")
                .setParameter("customerId", id)
                .getResultList();
    }

}
