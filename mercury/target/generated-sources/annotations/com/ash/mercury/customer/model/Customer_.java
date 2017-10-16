package com.ash.mercury.customer.model;

import com.ash.mercury.device.model.Device;
import com.ash.mercury.invoice.model.Invoice;
import com.ash.mercury.officeorder.model.OfficeOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-03T13:12:36")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile ListAttribute<Customer, Invoice> invoiceList;
    public static volatile SingularAttribute<Customer, String> customerSurname;
    public static volatile SingularAttribute<Customer, String> customerFirstname;
    public static volatile ListAttribute<Customer, OfficeOrder> officeOrderList;
    public static volatile SingularAttribute<Customer, String> customerEmail;
    public static volatile SingularAttribute<Customer, Integer> customerId;
    public static volatile ListAttribute<Customer, Device> deviceList;

}