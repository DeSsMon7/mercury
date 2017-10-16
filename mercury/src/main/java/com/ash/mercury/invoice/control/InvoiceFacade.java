package com.ash.mercury.invoice.control;

import com.ash.mercury.customer.control.AbstractFacade;
import com.ash.mercury.invoice.model.Invoice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Timmy
 */
@Stateless
public class InvoiceFacade extends AbstractFacade<Invoice> {

    @PersistenceContext(unitName = "com.ash_mercury_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Integer findNextSequence() {
        return (Integer) em.createNativeQuery("select max(invoice_id) from invoices")
                .getSingleResult();
    }

    public void createInvoice(Invoice i) {
        em.createNativeQuery("INSERT INTO public.invoices(invoice_id, invoice_date , invoice_price, employee_id, customer_id, office_order_id) VALUES (?1, ?2, ?3 ,?4 ,?5, ?6 )")
                .setParameter(1, i.getInvoiceId())
                .setParameter(2, i.getInvoiceDate())
                .setParameter(3, i.getInvoicePrice())
                .setParameter(4, i.getEmployeeId().getEmployeeId())
                .setParameter(5, i.getCustomerId().getCustomerId())
                .setParameter(6, i.getOfficeOrderId().getOfficeOrderId())
                .executeUpdate();
    }

    public InvoiceFacade() {
        super(Invoice.class);
    }

}
