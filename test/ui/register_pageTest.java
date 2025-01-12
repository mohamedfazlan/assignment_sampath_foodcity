/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import org.junit.After;


public class register_pageTest {
      private register_page registerPage; 

    public register_pageTest() {
        
    }
    
    @Before
    public void setUp() {
        registerPage = new register_page();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testRegister() {
    }

    
    @Test
    public void testMain() {
    }
    @Test
    public void checkValidRegistration() throws SQLException {
        String fullName = "John Doe";
        String email = "johndoe@gmail.com";
        String phoneNumber = "0776527865";
        String userType = "admin";  // Valid userType
        String password = "johndeo$123";

        String result = registerPage.register(fullName, email, phoneNumber, userType, password);

        assertEquals("success", result);
    }
    
    @Test
      public void checkEmptyFields() throws SQLException {
        String fullName = "";
        String email = "";
        String phoneNumber = "";
        String userType = "";
        String password = "";

        String result = registerPage.register(fullName, email, phoneNumber, userType, password);

        assertEquals("empty fields", result);
    }
      @Test
      public void checkInvalidUserType() throws SQLException {
        String fullName = "Jane Doe";
        String email = "janedoe@gmail.com";
        String phoneNumber = "0987654321";
        String userType = "guest";  // Invalid userType
        String password = "johndeo$123";

        String result = registerPage.register(fullName, email, phoneNumber, userType, password);
        assertEquals("invalid usertype", result);
    }

    
    
}
