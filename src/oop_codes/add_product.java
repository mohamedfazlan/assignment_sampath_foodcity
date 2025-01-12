/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_codes;

import java.sql.Date;


public class add_product {
   
    private int customerID;
    private int ProductID;
    private String productname;
    private int qty;
    private float unitprice;
    private Date date;
    private float totalprice;   
    private String region;
   

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    // Constructor
    public add_product(int customerID, int productID, String productName, int qty, float unitPrice, Date date, float totalPrice, String region) {
        this.customerID = customerID;
        this.ProductID = productID;
        this.productname = productName;
        this.qty = qty;
        this.unitprice = unitPrice;
        this.date = date;
        this.totalprice = totalPrice;
        this.region = region;
    }
}
