package com.ash.mercury.device.model;

import com.ash.mercury.customer.model.Customer;
import com.ash.mercury.officeorder.model.OfficeOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-04T21:00:59")
@StaticMetamodel(Device.class)
public class Device_ { 

    public static volatile SingularAttribute<Device, String> deviceType;
    public static volatile ListAttribute<Device, OfficeOrder> officeOrderList;
    public static volatile SingularAttribute<Device, Customer> customerId;
    public static volatile SingularAttribute<Device, String> deviceModel;
    public static volatile SingularAttribute<Device, Integer> deviceId;
    public static volatile SingularAttribute<Device, String> deviceBrand;

}