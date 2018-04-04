package com.ash.mercury.serviceslist.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Timmy
 */
@Entity
@Table(name = "services_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicesList.findAll", query = "SELECT s FROM ServicesList s")
    , @NamedQuery(name = "ServicesList.findByServiceListId", query = "SELECT s FROM ServicesList s WHERE s.serviceListId = :serviceListId")
    , @NamedQuery(name = "ServicesList.findByServiceId", query = "SELECT s FROM ServicesList s WHERE s.serviceId = :serviceId")
    , @NamedQuery(name = "ServicesList.findByServicePrice", query = "SELECT s FROM ServicesList s WHERE s.servicePrice = :servicePrice")
    , @NamedQuery(name = "ServicesList.findByOfficeOrderId", query = "SELECT s FROM ServicesList s WHERE s.officeOrderId = :officeOrderId")})
public class ServicesList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_list_id")
    private Integer serviceListId;
    @Column(name = "service_id")
    private Integer serviceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "service_price")
    private BigDecimal servicePrice;
    @Column(name = "office_order_id")
    private Integer officeOrderId;

    public ServicesList() {
    }

    public ServicesList(Integer serviceListId) {
        this.serviceListId = serviceListId;
    }

    public Integer getServiceListId() {
        return serviceListId;
    }

    public void setServiceListId(Integer serviceListId) {
        this.serviceListId = serviceListId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Integer getOfficeOrderId() {
        return officeOrderId;
    }

    public void setOfficeOrderId(Integer officeOrderId) {
        this.officeOrderId = officeOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceListId != null ? serviceListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicesList)) {
            return false;
        }
        ServicesList other = (ServicesList) object;
        if ((this.serviceListId == null && other.serviceListId != null) || (this.serviceListId != null && !this.serviceListId.equals(other.serviceListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ash.mercury.serviceslist.model.ServicesList[ serviceListId=" + serviceListId + " ]";
    }
    
}
