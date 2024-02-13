/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.prprocessingapp.pojo;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ankitgoyal
 */
@Entity
@Table(name="requisition")
public class Requisition {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int prid;
//    private int poid;
//    private String description;
    
//    @OneToMany(targetEntity = SupplierItem.class, mappedBy = "requisitionId", fetch = FetchType.EAGER)
//    private List<SupplierItem> supplierItemList;
//    
//    private String address;
////    @OneToOne
//    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
//    @JoinColumn(name="requisitionList")
//    private int customerId;
    
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "prId")
//    private Invoice invoice;
//    private String comments;
    private String status;
//    private Date prCreationDate;
//    private Date poCreationDate;
    private Double totalInvoiceAmount;

    public Requisition() {
    }

//    
//    public Date getPrCreationDate() {
//        return prCreationDate;
//    }
//
//    public void setPrCreationDate(Date prCreationDate) {
//        this.prCreationDate = prCreationDate;
//    }
//
//    public Date getPoCreationDate() {
//        return poCreationDate;
//    }
//
//    public void setPoCreationDate(Date poCreationDate) {
//        this.poCreationDate = poCreationDate;
//    }

    
    public int getPrid() {
        return prid;
    }

    public void setPrid(int prid) {
        this.prid = prid;
    }

//    public int getPoid() {
//        return poid;
//    }
//
//    public void setPoid(int poid) {
//        this.poid = poid;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }

//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
