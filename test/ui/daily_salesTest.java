package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;

public class daily_salesTest {

    private daily_sales testClass;
    private JDateChooser dateChooser;
    private JTable productTable;
    private JTable customerTable;
    private JTextField totalTextField;

    public daily_salesTest() {
    }

    @Before
    public void setUp() {
        // Initialize the objects before each test
        testClass = new daily_sales();
        dateChooser = new JDateChooser();
        productTable = new JTable(new DefaultTableModel(new Object[]{"Product Name", "Quantity", "Unit Price", "Total"}, 0));
        customerTable = new JTable(new DefaultTableModel(new Object[]{"Customer ID", "Region"}, 0));
        totalTextField = new JTextField();
    }

    @After
    public void tearDown() {
        // Cleanup after each test if necessary
    }

    @Test
    public void emptyfield() throws SQLException {
        // Test case when no date is selected
        dateChooser.setDate(null);
        testClass.daily_sales(dateChooser, productTable, customerTable, totalTextField);

        // Verify that the table is empty and total is not set
        assertEquals(0, productTable.getRowCount());
        assertTrue(totalTextField.getText().isEmpty());
    }

    @Test
    public void validData() throws SQLException {
        // Test case with a valid date
        dateChooser.setDate(java.sql.Date.valueOf("2022-12-31"));
        testClass.daily_sales(dateChooser, productTable, customerTable, totalTextField);

        // Verify that the table has data and the total is calculated
        assertTrue(productTable.getRowCount() > 0);
        assertTrue(Double.parseDouble(totalTextField.getText()) > 0);
    }

    @Test
    public void Invailddata() throws SQLException {

        //for the given date it will say no data found 
        dateChooser.setDate(java.sql.Date.valueOf("2025-05-02"));

        testClass.daily_sales(dateChooser, productTable, customerTable, totalTextField);

        if (productTable.getRowCount() == 0) {
            assertEquals("Table should have no rows for an invalid date range where no data is found", 0, productTable.getRowCount());
        } else if (customerTable.getRowCount() == 0) {
            assertEquals("Table should have no rows for an invalid date range where no data is found", 0, customerTable.getRowCount());

        } else {
            fail("Expected no data for the given invalid date range, but the table has rows.");
        }
    }

    @Test
    public void testMain() {
        // Optionally test the main method if it's relevant for your use case.
        // This can be left empty if not relevant.
    }
}
