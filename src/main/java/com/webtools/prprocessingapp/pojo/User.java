/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.prprocessingapp.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ankitgoyal
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Basic
    @Column(name="userid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userid;
    private String firstName;
    private String lastName;
    private String emailId;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserRole userRole;
    private String username;
    private String password;

//    @OneToMany(mappedBy="supplierId")
//    @OneToMany(targetEntity = SupplierItem.class, mappedBy = "supplierId", fetch = FetchType.EAGER)
//    private List<SupplierItem> supplierItems;
    
//    @OneToMany(targetEntity = Requisition.class, mappedBy = "customerId", fetch = FetchType.EAGER)
//    private List<Requisition> requisitionList;
//    
    public User() {
        super();
    }

    public User(String firstName, String lastName, String emailId, String username, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.username = username;
        this.password = password;
    }

//    public List<SupplierItem> getSupplierItems() {
//        return supplierItems;
//    }
//
//    public void setSupplierItems(List<SupplierItem> supplierItems) {
//        this.supplierItems = supplierItems;
//    }

    
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
