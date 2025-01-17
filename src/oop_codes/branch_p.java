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

public class branch_p {
     private String region;
    private String productName;
    private double totalSpent;

    // Constructor
    public branch_p(String region, String productName, double totalSpent) {
        this.region = region;
        this.productName = productName;
        this.totalSpent = totalSpent;
    }

    // Getters
    public String getRegion() {
        return region;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }
    
    
}
   




