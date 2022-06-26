/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.anwalt_sys;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Anwalt_Sys {

    public static void main(String[] args) throws SQLException {
        LoginGUI login = new LoginGUI();
        login.show();
       

        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;

    

        User user = new User();
        Client client = new Client();
        Cases cases = new Cases();

        UserManager userManager = new UserManager(new MySqlUserDal());
        ClientManager clientManager = new ClientManager();
        CaseManager caseManager = new CaseManager();

       

    }
}
