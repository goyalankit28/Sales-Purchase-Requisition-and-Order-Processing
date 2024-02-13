  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.prprocessingapp.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ankitgoyal
 */
@Entity
@Table(name = "supplieritem")
public class SupplierItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int itemid;
    private String itemType;
    private String itemName;
    private String itemDescription;
    private int quantity;
    private double price;
    private String currencyType;
    
//    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
//    @JoinColumn(name="supplierItems")
//    private User supplierId;
//    
//    @ManyToOne(targetEntity = Requisition.class, fetch = FetchType.EAGER)
//    @JoinColumn(name="requisitionId")
//    private Requisition requisitionId;
    
    public SupplierItem() {
    }

    public SupplierItem(String itemType, String itemName, String itemDescription, int quantity, double price, String currencyType) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.price = price;
        this.currencyType = currencyType;
    }

//    public User getSupplierId() {
//        return supplierId;
//    }
//
//    public void setSupplierId(User supplierId) {
//        this.supplierId = supplierId;
//    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

}
