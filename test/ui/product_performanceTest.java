package ui;

import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class product_performanceTest {

    private product_performance testClass;
    private JTable productTable;
    private JTextField productNameField;
    private JTextField regionField;

    public product_performanceTest() {
    }

    @Before
    public void setUp() {
        // Initialize the objects before each test
        testClass = new product_performance();
        productTable = new JTable(new DefaultTableModel(new Object[]{"Region", "Product Name", "Quantity", "Unit Price", "Total"}, 0));
        productNameField = new JTextField();
        regionField = new JTextField();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEmptyProductName() throws SQLException {
        // Test case when the product name is empty
        productNameField.setText("");  // Empty product name
        testClass.productPerformance(productNameField, productTable, regionField);

        // Verify that the table is empty and no region is displayed
        assertEquals("Table should be empty if no product name is entered", 0, productTable.getRowCount());
        assertTrue("Region field should be empty", regionField.getText().isEmpty());
    }

    @Test
    public void testValidProductName() throws SQLException {
        productNameField.setText("apple");  // Valid product name "beef"
        testClass.productPerformance(productNameField, productTable, regionField);

        // Verify that the table has data and region field is populated
        assertTrue("Table should have rows for the product", productTable.getRowCount() > 0);
        assertTrue("Region field should be populated", !regionField.getText().isEmpty());
    }

    @Test
    public void testInvalidProductName() throws SQLException {
        // Test case with an invalid product name
        productNameField.setText("Invalid Product Name");  // Example invalid product name
        testClass.productPerformance(productNameField, productTable, regionField);

        // Verify that the table is empty and no region is displayed
        assertEquals("Table should be empty if no data is found for the given product", 0, productTable.getRowCount());
        assertTrue("Region field should be empty when no data is found", regionField.getText().isEmpty());
    }
}
