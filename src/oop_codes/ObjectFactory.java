/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_codes;

import db.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author FAZLAN
 */
public class ObjectFactory {
    public static t_cal createCalculator(){
        return new t_cal2();
    }
    
     // Method to convert java.util.Date to java.sql.Date
    public static java.sql.Date convertToSqlDate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }
    
     public static Connection createDatabaseConnection() {
        return database.getConnection();
    }
     
     // Method to create a prepared statement
    public static PreparedStatement createPreparedStatement(Connection connection, String query) throws SQLException {
        return connection.prepareStatement(query);
    }
}
