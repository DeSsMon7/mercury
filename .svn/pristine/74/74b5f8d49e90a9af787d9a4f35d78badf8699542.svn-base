package com.ash.mercury.officeorder.model;

import com.ash.mercury.customer.model.Customer;
import com.ash.mercury.device.model.Device;
import com.ash.mercury.employee.model.Employee;
import com.ash.mercury.invoice.model.Invoice;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Timmy
 */
@Entity
@Table(name = "office_orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfficeOrder.findAll", query = "SELECT o FROM OfficeOrder o")
    , @NamedQuery(name = "OfficeOrder.findByOfficeOrderId", query = "SELECT o FROM OfficeOrder o WHERE o.officeOrderId = :officeOrderId")
    , @NamedQuery(name = "OfficeOrder.findByOfficeOrderDate", query = "SELECT o FROM OfficeOrder o WHERE o.officeOrderDate = :officeOrderDate")
    , @NamedQuery(name = "OfficeOrder.findByOfficeOrderInfo", query = "SELECT o FROM OfficeOrder o WHERE o.officeOrderInfo = :officeOrderInfo")
    , @NamedQuery(name = "OfficeOrder.findByOfficeOrderSum", query = "SELECT o FROM OfficeOrder o WHERE o.officeOrderSum = :officeOrderSum")
    , @NamedQuery(name = "OfficeOrder.findByOfficeOrderServiceDate", query = "SELECT o FROM OfficeOrder o WHERE o.officeOrderServiceDate = :officeOrderServiceDate")
    , @NamedQuery(name = "OfficeOrder.findByOfficeOrderServiceStatus", query = "SELECT o FROM OfficeOrder o WHERE o.officeOrderServiceStatus = :officeOrderServiceStatus")
    , @NamedQuery(name = "OfficeOrder.findByDeviceId", query = "SELECT o FROM OfficeOrder o WHERE o.deviceId = :deviceId")
    , @NamedQuery(name = "OfficeOrder.findByCustomerId", query = "SELECT o FROM OfficeOrder o WHERE o.customerId = :customerId")
    , @NamedQuery(name = "OfficeOrder.findByEmployeeId", query = "SELECT o FROM OfficeOrder o WHERE o.employeeId = :employeeId")
    , @NamedQuery(name = "OfficeOrder.findByServiceEmployeeId", query = "SELECT o FROM OfficeOrder o WHERE o.officeOrderServiceEmployeeId = :officeOrderServiceEmployeeId")})
public class OfficeOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_order_id")
    private Integer officeOrderId;
    @Column(name = "office_order_date")
    @Temporal(TemporalType.DATE)
    private Date officeOrderDate;
    @Size(max = 300)
    @Column(name = "office_order_info")
    private String officeOrderInfo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "office_order_sum")
    private BigDecimal officeOrderSum;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "device_id", referencedColumnName = "device_id")
    @ManyToOne
    private Device deviceId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee employeeId;
    @OneToMany(mappedBy = "officeOrderId")
    private List<Invoice> invoiceList;
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Column(name = "office_order_service_date")
    @Temporal(TemporalType.DATE)
    private Date officeOrderServiceDate;
    @Size(max = 30)
    @Column(name = "office_order_service_status")
    private String officeOrderServiceStatus;
    @JoinColumn(name = "office_order_service_employee_id" , referencedColumnName = "employee_id")
    @ManyToOne
    private Employee officeOrderServiceEmployeeId;
   
    
    
    public OfficeOrder() {
    }

    public OfficeOrder(Integer officeOrderId) {
        this.officeOrderId = officeOrderId;
    }

    public Integer getOfficeOrderId() {
        return officeOrderId;
    }

    public void setOfficeOrderId(Integer officeOrderId) {
        this.officeOrderId = officeOrderId;
    }

    public Date getOfficeOrderDate() {
        return officeOrderDate;
    }

    public void setOfficeOrderDate(Date officeOrderDate) {
        this.officeOrderDate = officeOrderDate;
    }

    public String getOfficeOrderInfo() {
        return officeOrderInfo;
    }

    public void setOfficeOrderInfo(String officeOrderInfo) {
        this.officeOrderInfo = officeOrderInfo;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Date getOfficeOrderServiceDate() {
        return officeOrderServiceDate;
    }

    public void setOfficeOrderServiceDate(Date officeOrderServiceDate) {
        this.officeOrderServiceDate = officeOrderServiceDate;
    }

    public String getOfficeOrderServiceStatus() {
        return officeOrderServiceStatus;
    }

    public void setOfficeOrderServiceStatus(String officeOrderServiceStatus) {
        this.officeOrderServiceStatus = officeOrderServiceStatus;
    }

    public Employee getServiceEmployeeId() {
        return officeOrderServiceEmployeeId;
    }

    public void setServiceEmployeeId(Employee officeOrderServiceEmployeeId) {
        this.officeOrderServiceEmployeeId = officeOrderServiceEmployeeId;
    }

    public BigDecimal getOfficeOrderSum() {
        return officeOrderSum;
    }

    public void setOfficeOrderSum(BigDecimal officeOrderSum) {
        this.officeOrderSum = officeOrderSum;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (officeOrderId != null ? officeOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfficeOrder)) {
            return false;
        }
        OfficeOrder other = (OfficeOrder) object;
        if ((this.officeOrderId == null && other.officeOrderId != null) || (this.officeOrderId != null && !this.officeOrderId.equals(other.officeOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ash.mercury.officeorder.model.OfficeOrder[ officeOrderId=" + officeOrderId + " ]";
    }

}
