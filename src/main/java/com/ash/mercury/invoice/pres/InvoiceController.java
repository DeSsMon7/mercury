package com.ash.mercury.invoice.pres;

import com.ash.mercury.customer.control.CustomerFacade;
import com.ash.mercury.customer.model.Customer;
import com.ash.mercury.invoice.model.Invoice;
import com.ash.mercury.customer.pres.util.JsfUtil;
import com.ash.mercury.customer.pres.util.JsfUtil.PersistAction;
import com.ash.mercury.employee.model.Employee;
import com.ash.mercury.invoice.control.InvoiceFacade;
import com.ash.mercury.officeorder.control.OfficeOrderFacade;
import com.ash.mercury.officeorder.model.OfficeOrder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named("invoiceController")
@SessionScoped
public class InvoiceController implements Serializable {

    private List<Invoice> items = null;
    private List<Invoice> filteredInvoices;
    private Invoice selected;
    private List<OfficeOrder> customerOrder;
    private List<OfficeOrder> officeOrderPrice;
    private List<Customer> selectedCustomer;

    @Inject
    InvoiceFacade ejbFacade;
    @Inject
    OfficeOrderFacade officeOrderFacade;
    @Inject
    CustomerFacade customerFacade;

    public InvoiceController() {
    }

    public void initCustomerOrder() {
        customerOrder = new ArrayList();
        customerOrder = officeOrderFacade.findCustomerOrder(selected.getCustomerId().getCustomerId());
    }

    public void initInvoicePrice() {
        officeOrderPrice = new ArrayList();
        officeOrderPrice = officeOrderFacade.findOfficeOrderSum(selected.getOfficeOrderId().getOfficeOrderId());
        selected.setInvoicePrice(selected.getOfficeOrderId().getOfficeOrderSum());
    }

    public Invoice getSelected() {
        if (selected == null) {
            selected = new Invoice();
        }
        return selected;
    }

    public void setSelected(Invoice selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private InvoiceFacade getFacade() {
        return ejbFacade;
    }

    public Invoice prepareCreate(ActionEvent event) {
        selected = new Invoice();
        initializeEmbeddableKey();
        return selected;
    }

    public Invoice prepareInvoice() {
        selected = new Invoice();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/msgs_EN").getString("InvoiceCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public Integer findNextSequence() {
        Integer result = ejbFacade.findNextSequence() + 1;
        return result;
    }

    public void insertNewInvoice(Invoice i) {
        ejbFacade.createInvoice(i);
    }

    public void createInvoice() {
        Invoice invoice1 = new Invoice();
        Integer invoiceId = findNextSequence();
        Integer officeOrderId = selected.getOfficeOrderId().getOfficeOrderId();
        selected.setInvoiceId(invoiceId);
        selected.setInvoiceDate(new Date());

        selected.setInvoicePrice(selected.getInvoicePrice() == null ? new BigDecimal(0) : selected.getInvoicePrice());

        insertNewInvoice(selected);
        officeOrderFacade.updateOfficeOrderInvoiceId(invoiceId, officeOrderId);
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/msgs_EN").getString("InvoiceUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/msgs_EN").getString("InvoiceDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Invoice> getItems() {
        items = getFacade().findAll();
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/msgs_EN").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/msgs_EN").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Invoice getInvoice(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Invoice> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Invoice> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Invoice.class)
    public static class InvoiceControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InvoiceController controller = (InvoiceController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "invoiceController");
            return controller.getInvoice(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Invoice) {
                Invoice o = (Invoice) object;
                return getStringKey(o.getInvoiceId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Invoice.class.getName()});
                return null;
            }
        }

    }

    public List<OfficeOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(List<OfficeOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public List<OfficeOrder> getOfficeOrderPrice() {
        return officeOrderPrice;
    }

    public void setOfficeOrderPrice(List<OfficeOrder> officeOrderPrice) {
        this.officeOrderPrice = officeOrderPrice;
    }

    public List<Customer> getSelectedCustomer() {
        System.out.println("Вика ли ме Invoice CustomerList" + selectedCustomer.size());
        selectedCustomer = new ArrayList();
        selectedCustomer = customerFacade.findAllCustomer();
        return selectedCustomer;

    }

    public void setSelectedCustomer(List<Customer> selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public List<Invoice> getFilteredInvoices() {
        return filteredInvoices;
    }

    public void setFilteredInvoices(List<Invoice> filteredInvoices) {
        this.filteredInvoices = filteredInvoices;
    }
}
