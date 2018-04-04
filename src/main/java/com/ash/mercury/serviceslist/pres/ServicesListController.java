package com.ash.mercury.serviceslist.pres;

import com.ash.mercury.serviceslist.model.ServicesList;
import com.ash.mercury.customer.pres.util.JsfUtil;
import com.ash.mercury.customer.pres.util.JsfUtil.PersistAction;
import com.ash.mercury.serviceslist.control.ServicesListFacade;

import java.io.Serializable;
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

@Named("servicesListController")
@SessionScoped
public class ServicesListController implements Serializable {

    @EJB
    private com.ash.mercury.serviceslist.control.ServicesListFacade ejbFacade;
    private List<ServicesList> items = null;
    private ServicesList selected;

    public ServicesListController() {
    }

    public ServicesList getSelected() {
        return selected;
    }

    public void setSelected(ServicesList selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ServicesListFacade getFacade() {
        return ejbFacade;
    }

    public ServicesList prepareCreate() {
        selected = new ServicesList();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/msgs_EN").getString("ServicesListCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/msgs_EN").getString("ServicesListUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/msgs_EN").getString("ServicesListDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ServicesList> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
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

    public ServicesList getServicesList(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ServicesList> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ServicesList> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ServicesList.class)
    public static class ServicesListControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServicesListController controller = (ServicesListController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "servicesListController");
            return controller.getServicesList(getKey(value));
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
            if (object instanceof ServicesList) {
                ServicesList o = (ServicesList) object;
                return getStringKey(o.getServiceListId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ServicesList.class.getName()});
                return null;
            }
        }

    }

}
