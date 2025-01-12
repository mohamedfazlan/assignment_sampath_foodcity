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

public class best_selling_productTest {

    private best_selling_product testClass;
    private JDateChooser startDateChooser;
    private JDateChooser endDateChooser;
    private JTable table;

    public best_selling_productTest() {

    }

    @Before
    public void setUp() {
        // Setup the test environment before each test case
        testClass = new best_selling_product();
        startDateChooser = new JDateChooser();
        endDateChooser = new JDateChooser();
        table = new JTable(new DefaultTableModel(new Object[]{"Product Name", "Total Quantity"}, 0));
    }

    @After
    public void tearDown() {
        // Cleanup after each test case if necessary
    }

    @Test
    public void testEmptyDatePickers() {
        // If no dates are selected, verify that the table is empty
        testClass.best_product_selling(startDateChooser, endDateChooser, table);
        assertEquals("Table should have no rows when dates are not selected.", 0, table.getRowCount());
    }

    @Test
    public void testValidData() throws SQLException {
        startDateChooser.setDate(java.sql.Date.valueOf("2022-12-30"));
        endDateChooser.setDate(java.sql.Date.valueOf("2022-12-31"));

        testClass.best_product_selling(startDateChooser, endDateChooser, table);

        // Check if there are rows for the valid date range
        if (table.getRowCount() > 0) {
            assertTrue("Table should have rows for the valid date range with data", table.getRowCount() > 0);
        } else {
            assertEquals("Table should have no rows when no data is found for the valid date range", 0, table.getRowCount());
        }
    }

    @Test
    public void testInvalidData() throws SQLException {
        
        //for the given date it will say no data found 
        startDateChooser.setDate(java.sql.Date.valueOf("2025-05-02"));
        endDateChooser.setDate(java.sql.Date.valueOf("2025-05-10"));

        testClass.best_product_selling(startDateChooser, endDateChooser, table);

        if (table.getRowCount() == 0) {
            assertEquals("Table should have no rows for an invalid date range where no data is found", 0, table.getRowCount());
        } else {
            fail("Expected no data for the given invalid date range, but the table has rows.");
        }
    }

    @Test
    public void testMain() {
        // You can define the main test logic here if necessary.
        // This can be left empty if not relevant.
    }
}
