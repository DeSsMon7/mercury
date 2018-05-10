package com.ash.mercury.officeorder.model;

import com.ash.mercury.customer.model.Customer;
import com.ash.mercury.device.model.Device;
import com.ash.mercury.employee.model.Employee;
import com.ash.mercury.invoice.model.Invoice;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T20:44:44")
@StaticMetamodel(OfficeOrder.class)
public class OfficeOrder_ { 

    public static volatile ListAttribute<OfficeOrder, Invoice> invoiceList;
    public static volatile SingularAttribute<OfficeOrder, Date> officeOrderDate;
    public static volatile SingularAttribute<OfficeOrder, String> officeOrderInfo;
    public static volatile SingularAttribute<OfficeOrder, Integer> officeOrderId;
    public static volatile SingularAttribute<OfficeOrder, Date> officeOrderServiceDate;
    public static volatile SingularAttribute<OfficeOrder, Employee> officeOrderServiceEmployeeId;
    public static volatile SingularAttribute<OfficeOrder, Customer> customerId;
    public static volatile SingularAttribute<OfficeOrder, String> officeOrderServiceStatus;
    public static volatile SingularAttribute<OfficeOrder, Employee> employeeId;
    public static volatile SingularAttribute<OfficeOrder, Integer> invoiceId;
    public static volatile SingularAttribute<OfficeOrder, Device> deviceId;
    public static volatile SingularAttribute<OfficeOrder, BigDecimal> officeOrderSum;

}