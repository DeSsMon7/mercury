package com.ash.mercury.invoice.model;

import com.ash.mercury.customer.model.Customer;
import com.ash.mercury.employee.model.Employee;
import com.ash.mercury.officeorder.model.OfficeOrder;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-14T20:17:34")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, OfficeOrder> officeOrderId;
    public static volatile SingularAttribute<Invoice, Customer> customerId;
    public static volatile SingularAttribute<Invoice, Integer> invoiceId;
    public static volatile SingularAttribute<Invoice, Employee> employeeId;
    public static volatile SingularAttribute<Invoice, Date> invoiceDate;
    public static volatile SingularAttribute<Invoice, BigDecimal> invoicePrice;

}