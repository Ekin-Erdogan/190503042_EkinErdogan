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
        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
    

    
        try{
            connection = helper.getConnection();
        statement = connection.prepareStatement("select userId,name,lastName,tc,role,telephoneNumber,"
                + "address,emailAddress,password");

        statement.executeUpdate();

    }
    catch (SQLException exception

    
        ){
            helper.showErrorMessage(exception);
    }

    
        finally {
            connection.close();
    }

    User user = new User();
    Client client = new Client();
    Cases cases = new Cases();

    UserManager userManager = new UserManager(new MySqlUserDal());
    ClientManager clientManager = new ClientManager();
    CaseManager caseManager = new CaseManager();
    
    LoginGUI login = new LoginGUI();
    login.show();
    
    }
}
