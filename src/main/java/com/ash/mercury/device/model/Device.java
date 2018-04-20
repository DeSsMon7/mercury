package com.ash.mercury.device.model;

import com.ash.mercury.customer.model.Customer;
import com.ash.mercury.officeorder.model.OfficeOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Timmy
 */
@Entity
@Table(name = "devices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d")
    , @NamedQuery(name = "Device.findByDeviceId", query = "SELECT d FROM Device d WHERE d.deviceId = :deviceId")
    , @NamedQuery(name = "Device.findByDeviceType", query = "SELECT d FROM Device d WHERE d.deviceType = :deviceType")
    , @NamedQuery(name = "Device.findByDeviceBrand", query = "SELECT d FROM Device d WHERE d.deviceBrand = :deviceBrand")
    , @NamedQuery(name = "Device.findByDeviceModel", query = "SELECT d FROM Device d WHERE d.deviceModel = :deviceModel")
    , @NamedQuery(name = "Device.findByCustomerId", query = "SELECT d FROM Device d WHERE d.customerId = :customerId")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "device_id")
    private Integer deviceId;
    @Size(max = 100)
    @Column(name = "device_type")
    private String deviceType;
    @Size(max = 100)
    @Column(name = "device_brand")
    private String deviceBrand;
    @Size(max = 100)
    @Column(name = "device_model")
    private String deviceModel;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @OneToMany(mappedBy = "deviceId")
    private List<OfficeOrder> officeOrderList;

    public Device() {
    }

    public Device(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @XmlTransient
    public List<OfficeOrder> getOfficeOrderList() {
        return officeOrderList;
    }

    public void setOfficeOrderList(List<OfficeOrder> officeOrderList) {
        this.officeOrderList = officeOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceId != null ? deviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.deviceId == null && other.deviceId != null) || (this.deviceId != null && !this.deviceId.equals(other.deviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ash.mercury.customer.model.Device[ deviceId=" + deviceId + " ]";
    }
    
}
