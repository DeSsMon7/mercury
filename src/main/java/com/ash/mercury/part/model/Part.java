/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ash.mercury.part.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Timmy
 */
@Entity
@Table(name = "parts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Part.findAll", query = "SELECT p FROM Part p")
    , @NamedQuery(name = "Part.findByPartId", query = "SELECT p FROM Part p WHERE p.partId = :partId")
    , @NamedQuery(name = "Part.findByPartInfo", query = "SELECT p FROM Part p WHERE p.partInfo = :partInfo")
    , @NamedQuery(name = "Part.findByPartUnitPrice", query = "SELECT p FROM Part p WHERE p.partUnitPrice = :partUnitPrice")
    , @NamedQuery(name = "Part.findByPartInstock", query = "SELECT p FROM Part p WHERE p.partInstock = :partInstock")})
public class Part implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "part_id")
    private Integer partId;
    @Size(max = 500)
    @Column(name = "part_info")
    private String partInfo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "part_unit_price")
    private BigDecimal partUnitPrice;
    @Column(name = "part_instock")
    private Integer partInstock;

    public Part() {
    }

    public Part(Integer partId) {
        this.partId = partId;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public String getPartInfo() {
        return partInfo;
    }

    public void setPartInfo(String partInfo) {
        this.partInfo = partInfo;
    }

    public BigDecimal getPartUnitPrice() {
        return partUnitPrice;
    }

    public void setPartUnitPrice(BigDecimal partUnitPrice) {
        this.partUnitPrice = partUnitPrice;
    }

    public Integer getPartInstock() {
        return partInstock;
    }

    public void setPartInstock(Integer partInstock) {
        this.partInstock = partInstock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partId != null ? partId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Part)) {
            return false;
        }
        Part other = (Part) object;
        if ((this.partId == null && other.partId != null) || (this.partId != null && !this.partId.equals(other.partId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ash.mercury.part.model.Part[ partId=" + partId + " ]";
    }
    
}
