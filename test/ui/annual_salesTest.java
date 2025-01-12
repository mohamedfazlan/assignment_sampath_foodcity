/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FAZLAN
 */
public class annual_salesTest {

    private JTextField txtYear;
    private JTextField txtTotal;
    private JTable productTable;
    private JTable customerTable;

    public annual_salesTest() {
    }

    @Before
    public void setUp() {
        txtYear = new JTextField();
        txtTotal = new JTextField();
        productTable = new JTable();
        customerTable = new JTable();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of annual_sales method, of class annual_sales.
     */
    @Test
    public void testAnnual_sales() {
    }

    /**
     * Test of main method, of class annual_sales.
     */
    @Test
    public void testMain() {
    }

    @Test
    public void ValidYear() throws SQLException {
        // Set a valid year
        txtYear.setText("2022");

        // Call the method
        annual_sales obj = new annual_sales();
        obj.annual_sales(txtYear, txtTotal, productTable, customerTable);

        // Verify product table is populated
        DefaultTableModel productModel = (DefaultTableModel) productTable.getModel();
        assertTrue(productModel.getRowCount() > 0);

        // Verify customer table is populated
        DefaultTableModel customerModel = (DefaultTableModel) customerTable.getModel();
        assertTrue(customerModel.getRowCount() > 0);

        // Verify total sales field is updated
        assertFalse(txtTotal.getText().isEmpty());
        assertTrue(Double.parseDouble(txtTotal.getText()) > 0);
    }

    @Test
    public void InvalidYear() throws SQLException {
        // Setting an invalid year
        txtYear.setText("12345");

        // Call the method
        annual_sales obj = new annual_sales();
        obj.annual_sales(txtYear, txtTotal, productTable, customerTable);

        // Verify product table is empty
        DefaultTableModel productModel = (DefaultTableModel) productTable.getModel();
        assertEquals(0, productModel.getRowCount());

        // Verify customer table is empty
        DefaultTableModel customerModel = (DefaultTableModel) customerTable.getModel();
        assertEquals(0, customerModel.getRowCount());

        // Verify total sales field is empty
        assertEquals("", txtTotal.getText());
    }

    @Test
    public void EmptyYear() throws SQLException {
        // Set an empty year
        txtYear.setText("");

        // Call the method
        annual_sales obj = new annual_sales();
        obj.annual_sales(txtYear, txtTotal, productTable, customerTable);

        // Verify product table is empty
        DefaultTableModel productModel = (DefaultTableModel) productTable.getModel();
        assertEquals(0, productModel.getRowCount());

        // Verify customer table is empty
        DefaultTableModel customerModel = (DefaultTableModel) customerTable.getModel();
        assertEquals(0, customerModel.getRowCount());

        // Verify total sales field is empty
        assertEquals("", txtTotal.getText());
    }

}
