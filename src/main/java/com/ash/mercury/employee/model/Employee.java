package com.ash.mercury.employee.model;

import com.ash.mercury.invoice.model.Invoice;
import com.ash.mercury.officeorder.model.OfficeOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee.findByEmployeeFirstname", query = "SELECT e FROM Employee e WHERE e.employeeFirstname = :employeeFirstname")
    , @NamedQuery(name = "Employee.findByEmployeeSurname", query = "SELECT e FROM Employee e WHERE e.employeeSurname = :employeeSurname")
    , @NamedQuery(name = "Employee.findByEmployeeLogin", query = "SELECT e FROM Employee e WHERE e.employeeLogin = :employeeLogin")
    , @NamedQuery(name = "Employee.findByEmployeePassword", query = "SELECT e FROM Employee e WHERE e.employeePassword = :employeePassword")
    , @NamedQuery(name = "Employee.findByEmployeeEmail", query = "SELECT e FROM Employee e WHERE e.employeeEmail = :employeeEmail")
    , @NamedQuery(name = "Employee.findByEmployeeRole", query = "SELECT e FROM Employee e WHERE e.employeeRole = :employeeRole")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Size(max = 100)
    @Column(name = "employee_firstname")
    private String employeeFirstname;
    @Size(max = 100)
    @Column(name = "employee_surname")
    private String employeeSurname;
    @Size(max = 100)
    @Column(name = "employee_login")
    private String employeeLogin;
    @Size(max = 100)
    @Column(name = "employee_password")
    private String employeePassword;
    @Size(max = 100)
    @Column(name = "employee_email")
    private String employeeEmail;
    @Size(max = 100)
    @Column(name = "employee_role")
    private String employeeRole;
    @OneToMany(mappedBy = "employeeId")
    private List<OfficeOrder> officeOrderList;
    @OneToMany(mappedBy = "employeeId")
    private List<Invoice> invoiceList;
    
    public Employee() {
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstname() {
        return employeeFirstname;
    }

    public void setEmployeeFirstname(String employeeFirstname) {
        this.employeeFirstname = employeeFirstname;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeLogin() {
        return employeeLogin;
    }

    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    @XmlTransient
    public List<OfficeOrder> getOfficeOrderList() {
        return officeOrderList;
    }

    public void setOfficeOrderList(List<OfficeOrder> officeOrderList) {
        this.officeOrderList = officeOrderList;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ash.mercury.employee.model.Employee[ employeeId=" + employeeId + " ]";
    }

}
