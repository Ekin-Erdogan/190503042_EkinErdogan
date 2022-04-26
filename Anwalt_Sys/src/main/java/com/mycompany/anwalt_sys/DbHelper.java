/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anwalt_sys;

/**
 *
 * @author Dell
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    private String username = "root";
    private String password = "12345";
    private String dburl = "jdbc:mysql://localhost:3306/anwalt_sys";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, username, password);

    }

    public void showErrorMessage(SQLException exception) {
        System.out.println("Error : " + exception.getMessage());
        System.out.println("Error Code : " + exception.getErrorCode());
    }

}
