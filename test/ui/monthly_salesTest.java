/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author FAZLAN
 */
public class monthly_salesTest {

    private monthly_sales testClass; // Replace with the actual class
    private JDateChooser startDateChooser;
    private JDateChooser endDateChooser;
    private JTable productTable;
    private JTable customerTable;
    private JTextField totalTextField;

    public monthly_salesTest() {
    }

    @Before
    public void setUp() {
        testClass = new monthly_sales();  // Replace with your class that contains the method
        startDateChooser = new JDateChooser();
        endDateChooser = new JDateChooser();
        productTable = new JTable(new DefaultTableModel(new Object[]{"Product Name", "Quantity", "Unit Price", "Total"}, 0));
        customerTable = new JTable(new DefaultTableModel(new Object[]{"Customer ID", "Region"}, 0));
        totalTextField = new JTextField();
    }

    @After
    public void tearDown() {
    }

    
    @Test
    public void testMonthly_sales() {

    }
    
    @Test
     public void testEmpty() throws SQLException {
        // Test case when no start and end date is selected
        startDateChooser.setDate(null);
        endDateChooser.setDate(null);
        testClass.monthly_sales(startDateChooser, endDateChooser, productTable, customerTable, totalTextField);

        // Verify that the tables are empty and total is not set
        assertEquals("Product table should have no rows when no dates are selected.", 0, productTable.getRowCount());
        assertEquals("Customer table should have no rows when no dates are selected.", 0, customerTable.getRowCount());
        assertTrue("Total sales field should be empty when no dates are selected.", totalTextField.getText().isEmpty());
    }
    @Test
     public void testValid() throws SQLException {
        // Test case with a valid date range
        startDateChooser.setDate(java.sql.Date.valueOf("2022-12-01"));
        endDateChooser.setDate(java.sql.Date.valueOf("2022-12-31"));
        testClass.monthly_sales(startDateChooser, endDateChooser, productTable, customerTable, totalTextField);

        // Verify that the tables have data and total sales is calculated
        assertTrue("Product table should have rows for the valid date range.", productTable.getRowCount() > 0);
        assertTrue("Customer table should have rows for the valid date range.", customerTable.getRowCount() > 0);
        assertTrue("Total sales should be greater than 0 for the valid date range.", Double.parseDouble(totalTextField.getText()) > 0);
    }
    @Test
    public void testInvalid() throws SQLException {
        
        //for the given date it will say no data found 
        startDateChooser.setDate(java.sql.Date.valueOf("2025-05-02"));
        endDateChooser.setDate(java.sql.Date.valueOf("2025-05-10"));

        testClass.monthly_sales(startDateChooser, endDateChooser, productTable,customerTable,totalTextField);

        if (productTable.getRowCount() == 0) {
            assertEquals("Table should have no rows for an invalid date range where no data is found", 0, productTable.getRowCount());
        }else if (customerTable.getRowCount() == 0) {
            assertEquals("Table should have no rows for an invalid date range where no data is found", 0, customerTable.getRowCount());

        }
        
        else {
            fail("Expected no data for the given invalid date range, but the table has rows.");
        }
    }


    
    @Test
    public void testMain() {
    }

}
