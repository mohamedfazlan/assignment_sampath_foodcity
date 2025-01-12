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
public class Total {
    private int quantity;
    private float unitPrice;

    // Constructor
    public Total(int quantity, float unitPrice) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Method to calculate total price
    public float calculateTotalPrice() {
        return quantity * unitPrice;
    }
}

