package com.ash.mercury.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/mercurydb", "postgres", "1234");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database.getConnection() Error -->"
                    + ex.getMessage());
            return null;
        }
    }
    
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}