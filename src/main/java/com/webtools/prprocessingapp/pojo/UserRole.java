/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.prprocessingapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ankitgoyal
 */
@Entity    
@Table(name = "userrole")    
public class UserRole {    
	    
	 @Id    
	 @GeneratedValue(strategy = GenerationType.IDENTITY)    
	 @Column(name = "user_role_id", unique = true)    
	 private Integer userRoleId;    
	    
	 @OneToOne(fetch = FetchType.LAZY ,targetEntity = User.class)    
	 @JoinColumn(name = "userId")    
	 private User user;    
	 
	@Column(name = "role", length = 45)    
	 private String role;    
	    
	 public UserRole() {
             super();
		 
         }
	    
	 public UserRole(String role) {
		super();
		this.role = role;
	} 
        public Integer getUserRoleId() {    
	  return userRoleId;    
	 }    
	    
	 public void setUserRoleId(Integer userRoleId) {    
	  this.userRoleId = userRoleId;    
	 }    
	    
	 public User getUser() {    
	  return user;    
	 }    
	    
	 public void setUser(User user) {    
	  this.user = user;    
	 }    
	    
	 public String getRole() {    
	  return role;    
	 }    
	    
	 public void setRole(String role) {    
	  this.role = role;    
	 }    

}
