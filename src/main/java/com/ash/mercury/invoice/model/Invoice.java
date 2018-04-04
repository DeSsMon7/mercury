package com.ash.mercury.invoice.model;

import com.ash.mercury.customer.model.Customer;
import com.ash.mercury.employee.model.Employee;
import com.ash.mercury.officeorder.model.OfficeOrder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Timmy
 */
@Entity
@Table(name = "invoices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")
    , @NamedQuery(name = "Invoice.findByInvoiceId", query = "SELECT i FROM Invoice i WHERE i.invoiceId = :invoiceId")
    , @NamedQuery(name = "Invoice.findByInvoiceDate", query = "SELECT i FROM Invoice i WHERE i.invoiceDate = :invoiceDate")
    , @NamedQuery(name = "Invoice.findByInvoicePrice", query = "SELECT i FROM Invoice i WHERE i.invoicePrice = :invoicePrice")
    , @NamedQuery(name = "Invoice.findByCustomerId", query = "SELECT i FROM Invoice i WHERE i.customerId = :customerId")
    , @NamedQuery(name = "Invoice.findByEmployeeId", query = "SELECT i FROM Invoice i WHERE i.employeeId = :employeeId")
    , @NamedQuery(name = "Invoice.findByOfficeOrderId", query = "SELECT i FROM Invoice i WHERE i.officeOrderId = :officeOrderId")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "invoice_price")
    private BigDecimal invoicePrice;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee employeeId;
    @JoinColumn(name = "office_order_id", referencedColumnName = "office_order_id")
    @ManyToOne
    private OfficeOrder officeOrderId;

    public Invoice() {
    }

    public Invoice(Customer customerId, Employee employeeId, OfficeOrder officeOrderId) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.officeOrderId = officeOrderId;
    }

    public Invoice(Integer invoiceId, Date invoiceDate, BigDecimal invoicePrice, Customer customerId, Employee employeeId, OfficeOrder officeOrderId) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.invoicePrice = invoicePrice;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.officeOrderId = officeOrderId;
    }

    public Invoice(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(BigDecimal invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public OfficeOrder getOfficeOrderId() {
        return officeOrderId;
    }

    public void setOfficeOrderId(OfficeOrder officeOrderId) {
        this.officeOrderId = officeOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ash.mercury.invoice.model.Invoice[ invoiceId=" + invoiceId + " ]";
    }
    
}
