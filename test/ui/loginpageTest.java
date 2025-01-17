package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;

public class loginpageTest {

    private loginpage loginPage; // Declare loginPage object

    public loginpageTest() {
    }

    @Before
    public void setUp() {
        //loginPage object before each test
        loginPage = new loginpage();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void checkEmpty() throws SQLException {
        // Test for empty fields
        String username = "";
        String password = "";
        String userType = "";

        String result = loginPage.login(username, password, userType);

        assertEquals("Expected empty fields message", "empty fields", result);
    }

    @Test
    public void checkInvalid() throws SQLException {
        // Test for invalid credentials (wrong username/password combination)
        String username = "john123";
        String password = "123";
        String userType = "admin";

        String result = loginPage.login(username, password, userType);

        assertEquals("Expected invalid credentials message", "invalid credentials", result);
    }

    
    @Test
    public void checkAdminValid() throws SQLException {
        // Test for valid credentials with correct username, password, and userType
        String username = "james@gmail.com";
        String password = "123"; // Correct password as per the database
        String userType = "admin"; // Valid userType

        String result = loginPage.login(username, password, userType);

        assertEquals("Expected success message", "success", result);
    }

    @Test
    public void checkEmployeeValid() throws SQLException {
        // Test for employee valid login
        String username = "harry@gmail.com";
        String password = "harry@123";
        String userType = "employee";

        String result = loginPage.login(username, password, userType);

        assertEquals("Expected success message", "success", result);
    }
}
