
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.prprocessingapp.pojo;

import java.util.Date;
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
@Table(name = "invoice")
class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Requisition.class)
    @JoinColumn(name = "prid")
    private Requisition prId;
    private double invoice_amount;
    private String currencyType;
    private Date invoice_creation_date;
    private Date invoice_payment_date;

    public Invoice() {
    }

    public Invoice(double invoice_amount, String currencyType, Date invoice_creation_date, Date invoice_payment_date) {
        this.invoice_amount = invoice_amount;
        this.currencyType = currencyType;
        this.invoice_creation_date = invoice_creation_date;
        this.invoice_payment_date = invoice_payment_date;
    }

    
    public Requisition getPrId() {
        return prId;
    }

    public void setPrId(Requisition prId) {
        this.prId = prId;
    }

    

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }


    public double getInvoice_amount() {
        return invoice_amount;
    }

    public void setInvoice_amount(double invoice_amount) {
        this.invoice_amount = invoice_amount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Date getInvoice_creation_date() {
        return invoice_creation_date;
    }

    public void setInvoice_creation_date(Date invoice_creation_date) {
        this.invoice_creation_date = invoice_creation_date;
    }

    public Date getInvoice_payment_date() {
        return invoice_payment_date;
    }

    public void setInvoice_payment_date(Date invoice_payment_date) {
        this.invoice_payment_date = invoice_payment_date;
    }

}
