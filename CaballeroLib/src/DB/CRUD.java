/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

/**
 *
 * @author caballeroda_sd2081
 */
public class CRUD {
    public Connection connectToDB() {
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/dainedb";
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myUrl, "root", "");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("An error occur!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean addData(String sqlString) {
        System.out.println(sqlString);
        try {
            Connection connection = connectToDB();
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }

    public ResultSet getData(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = connectToDB();
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

}