package com.ash.mercury.part.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-12T17:40:48")
@StaticMetamodel(Part.class)
public class Part_ { 

    public static volatile SingularAttribute<Part, Integer> partInstock;
    public static volatile SingularAttribute<Part, Integer> partId;
    public static volatile SingularAttribute<Part, BigDecimal> partUnitPrice;
    public static volatile SingularAttribute<Part, String> partInfo;

}