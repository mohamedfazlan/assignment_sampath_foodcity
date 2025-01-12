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
  // produtc_performance class
    public class produtc_performance {
        private String productName;
        private int quantity;
        private double unitPrice;
        private double total;

        // Constructor
        public produtc_performance(String productName, int quantity, double unitPrice) {
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.total = quantity * unitPrice;
        }

        // Getters
        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public double getTotal() {
            return total;
        }
    }


