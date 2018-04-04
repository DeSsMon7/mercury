package com.ash.mercury.servicepart.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-04T21:00:59")
@StaticMetamodel(ServicePart.class)
public class ServicePart_ { 

    public static volatile SingularAttribute<ServicePart, BigDecimal> partTotalPrice;
    public static volatile SingularAttribute<ServicePart, Integer> officeOrderId;
    public static volatile SingularAttribute<ServicePart, Integer> partId;
    public static volatile SingularAttribute<ServicePart, Integer> partQuantity;
    public static volatile SingularAttribute<ServicePart, BigDecimal> partUnitPrice;
    public static volatile SingularAttribute<ServicePart, Integer> servicePartId;

}