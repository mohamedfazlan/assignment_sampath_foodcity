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
public class brach_performanceTest {

    public brach_performanceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of branch_performance method, of class brach_performance.
     */
    @Test
    public void testBranch_performance() {
    }

    @Test
    public void testValidRegionInput() throws SQLException {
        // Create components
        JTable customer_analysis_table = new JTable();
        JTextField total = new JTextField();
        JTextField total_qty = new JTextField();
        JTextField txtProduct = new JTextField();

        // Create object of the class
        brach_performance obj = new brach_performance();

        // Call the method with a valid region ()
        obj.branch_performance("galle", customer_analysis_table, total, total_qty, txtProduct);

        // Verify totals and most sold product are not empty
        assertNotEquals("Total spent should not be empty for valid region", "", total.getText());
        assertNotEquals("Total quantity should not be empty for valid region", "", total_qty.getText());
        assertNotEquals("Most sold product should not be empty for valid region", "", txtProduct.getText());

        // Verify table has data
        DefaultTableModel model = (DefaultTableModel) customer_analysis_table.getModel();
        assertTrue("Table should have data for valid region", model.getRowCount() > 0);
    }

    @Test
    public void testInvalidRegionInput() throws SQLException {
        // Create components
        JTable customer_analysis_table = new JTable();
        JTextField total = new JTextField();
        JTextField total_qty = new JTextField();
        JTextField txtProduct = new JTextField();

        // Create object of the class
        brach_performance obj = new brach_performance();

        // Call the method with an invalid region
        obj.branch_performance("InvalidRegion", customer_analysis_table, total, total_qty, txtProduct);

        // Verify totals and most sold product are empty
        assertEquals("Total spent should be empty for invalid region", "", total.getText());
        assertEquals("Total quantity should be empty for invalid region", "", total_qty.getText());
        assertEquals("Most sold product should be empty for invalid region", "", txtProduct.getText());

        // Verify table has no data
        DefaultTableModel model = (DefaultTableModel) customer_analysis_table.getModel();
        assertEquals("Table should have no data for invalid region", 0, model.getRowCount());
    }

    @Test
    public void testEmptyRegionInput() throws SQLException {
        // Create components
        JTable customer_analysis_table = new JTable();
        JTextField total = new JTextField();
        JTextField total_qty = new JTextField();
        JTextField txtProduct = new JTextField();

        // Create object of the class
        brach_performance obj = new brach_performance();

        // Call the method with an empty region
        obj.branch_performance("", customer_analysis_table, total, total_qty, txtProduct);

        // Verify totals and most sold product are empty
        assertEquals("Total spent should be empty for empty region", "", total.getText());
        assertEquals("Total quantity should be empty for empty region", "", total_qty.getText());
        assertEquals("Most sold product should be empty for empty region", "", txtProduct.getText());

        // Verify table has no data
        DefaultTableModel model = (DefaultTableModel) customer_analysis_table.getModel();
        assertEquals("Table should have no data for empty region", 0, model.getRowCount());
    }
}
