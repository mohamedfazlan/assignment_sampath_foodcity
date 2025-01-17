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


public class customer_beharivorTest {

    private JTextField txt_cid;
    private JTable customer_analysis_table;

    public customer_beharivorTest() {

    }

    @Before
    public void setUp() {
        txt_cid = new JTextField();
        customer_analysis_table = new JTable();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class customer_beharivor.
     */
    @Test
    public void testMain() {
    }

    @Test
    public void testValidCustomerId() throws SQLException {
        // Valid customer ID
        txt_cid.setText("519");  // Set a valid customer ID

        // Call the method
        customer_beharivor obj = new customer_beharivor();
        obj.customer_behavriour(txt_cid, customer_analysis_table);

        // Check if the table has been populated
        DefaultTableModel model = (DefaultTableModel) customer_analysis_table.getModel();
        assertTrue(model.getRowCount() > 0);  // Verify that rows are added to the table
    }

    @Test
    public void testInvalidCustomerId() throws SQLException {
        // Invalid customer ID (negative or invalid)
        txt_cid.setText("121");

        // Call the method
        customer_beharivor obj = new customer_beharivor();

        obj.customer_behavriour(txt_cid, customer_analysis_table);

        // Ensure the table is empty
        DefaultTableModel model = (DefaultTableModel) customer_analysis_table.getModel();
        assertTrue(model.getRowCount() == 0);  // Verify no rows were added
    }
    
    
    @Test
    public void testEmptyCustomerId() throws SQLException {
        // Empty customer ID
        txt_cid.setText("");

        // Call the method
        customer_beharivor obj1 = new customer_beharivor();
        obj1.customer_behavriour(txt_cid, customer_analysis_table);

        // Ensure the table is empty
        DefaultTableModel model = (DefaultTableModel) customer_analysis_table.getModel();
        assertTrue(model.getRowCount() == 0);  // Verify no rows were added
    }

}
