package com.ash.mercury.employee.model;

import com.ash.mercury.invoice.model.Invoice;
import com.ash.mercury.officeorder.model.OfficeOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-11T18:56:50")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> employeeLogin;
    public static volatile ListAttribute<Employee, Invoice> invoiceList;
    public static volatile ListAttribute<Employee, OfficeOrder> officeOrderList;
    public static volatile SingularAttribute<Employee, String> employeeEmail;
    public static volatile SingularAttribute<Employee, Integer> employeeId;
    public static volatile SingularAttribute<Employee, String> employeeFirstname;
    public static volatile SingularAttribute<Employee, String> employeeSurname;
    public static volatile SingularAttribute<Employee, String> employeePassword;
    public static volatile SingularAttribute<Employee, String> employeeRole;

}