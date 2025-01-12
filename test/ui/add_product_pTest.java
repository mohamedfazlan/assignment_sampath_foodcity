package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.sql.*;

public class add_product_pTest {

    protected add_product_p addProductPage; // The class you are testing

    public add_product_pTest() {
    }

    @Before
    public void setUp() {
        // Initialize the add_product_p object
        addProductPage = new add_product_p();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testProductList() {
        // You can implement this test if needed
    }

    @Test
    public void testShowProducts() {
        // You can implement this test if needed
    }

    @Test
    public void testValid() throws SQLException {
        // Test valid case for inserting a product
        String customerid = "301";
        String productid = "103";
        String productname = "Bread";
        String unitprice = "3";
        String region = "Matara";
        String qty = "3";
        Date utilDate = new Date();  // Example current date

        // Parse the quantity and unit price
        int quantity = Integer.parseInt(qty);
        float pricePerUnit = Float.parseFloat(unitprice);

        // Calculate the expected total price
        float expectedTotalPrice = quantity * pricePerUnit;

        // Call insert_product method
        String result = addProductPage.insert_product(customerid, productid, productname, unitprice, region, qty, utilDate);

        // Assert that the product is added successfully
        assertEquals("Product Successfully Added", result);

        // Assert that the total price is correct
        String formattedTotalPrice = String.format("%.2f", expectedTotalPrice);
        // Corrected the extra period and method usage
        assertEquals(formattedTotalPrice, addProductPage.getTxtPriceText());  // Use the getter method to access txtprice text
    }

    @Test
    public void testEmptyFields() throws SQLException {
        // Empty fields should trigger validation error
        String customerid = "";
        String productid = "";
        String productname = "";
        String unitprice = "";
        String region = "";
        String qty = "";
        Date utilDate = new Date();  // Example current date

        String result = addProductPage.insert_product(customerid, productid, productname, unitprice, region, qty, utilDate);

        // Expecting "Please fill in all required fields" as an error
        assertEquals("Please fill in all required fields", result);
    }

    @Test
    public void testInvalidData() throws SQLException {
        // Invalid quantity and unit price should result in error
        String customerid = "1";
        String productid = "101";
        String productname = "Bread";
        String unitprice = "abc";  // Invalid unit price (non-numeric)
        String region = "Matara";
        String qty = "2";  // Corrected to valid quantity
        Date utilDate = new Date();  // Example current date

        String result = addProductPage.insert_product(customerid, productid, productname, unitprice, region, qty, utilDate);

        // Check for invalid data error (specific exception message or pattern)
        assertTrue(result.contains("For input string"));
    }

    @Test
    public void testMain() {
        // This test can be implemented if needed
    }
}
