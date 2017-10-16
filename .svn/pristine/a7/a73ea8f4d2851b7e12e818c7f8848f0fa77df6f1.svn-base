package com.ash.mercury.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ash.mercury.login.util.DataConnect;

public class LoginDAO {

    public static boolean validate(String employeeLogin, String employeePassword) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select employee_login, employee_password from Employees where employee_login = ? and employee_password = ?");
            ps.setString(1, employeeLogin);
            ps.setString(2, employeePassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Im in LoginDAO.java: the query select is returned true!");
                return true;
            } else {
                System.out.println("Im in LoginDAO.java: the query select is returned false!");
                System.out.println("Login failed!");
                System.out.println("Employee Login: " + employeeLogin);
                System.out.println("Employee Password: " + employeePassword);
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
            System.out.println("Finaly dataConnection close");
        }
        return false;
    }

}
