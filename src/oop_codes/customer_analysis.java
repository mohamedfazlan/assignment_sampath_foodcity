/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_codes;

/**
 *
 * @author FAZLAN
 */
public class customer_analysis {
    // Class representing customer details (Encapsulation)

    private String region;
    private String productName;
    private double totalSpent;

    // Getter for region
    public String getRegion() {
        return region;
    }

    // Setter for region
    public void setRegion(String region) {
        this.region = region;
    }

    // Getter for productName
    public String getProductName() {
        return productName;
    }

    // Setter for productName
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter for totalSpent
    public double getTotalSpent() {
        return totalSpent;
    }

    

    // Constructor
    public customer_analysis(String region, String productName, double totalSpent) {
        this.region = region;
        this.productName = productName;
        this.totalSpent = totalSpent;
    }

  
}





