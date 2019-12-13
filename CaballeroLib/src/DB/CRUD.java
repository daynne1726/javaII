
  
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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author belciñaan_sd2081
 */
public class CRUD {
    
    public Connection dbConn(){
         // create a mysql database connection
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost/caballero";
        try {
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myUrl, "root", "");
            return connection;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return null;
        }    
    }
    


    public Boolean insertData(String table, String columns, String values[]) {
        try {
            Connection conn = dbConn();
            Statement st = conn.createStatement();
            String query = "Insert into " + table + "("+ columns +")values ('" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "','" + values[4] + "','" + values[5] + "')";  
            System.out.println(query);
            st.executeUpdate(query);
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }     
    }
    public Boolean addDataWordCount(String query) {
        try {
            Connection conn = dbConn();
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }     
    }
    
    public ResultSet showData(String table, String columns){
        String query = "SELECT "+columns+" FROM "+table;
        try {
            ResultSet rs ;
            Connection conn = dbConn();
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            System.out.println(rs);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }
    
    public ResultSet logIn(String table, String columnEmail, String uname,String columnPassword, String pass){
        String query = "SELECT * FROM "+table+" WHERE "+columnEmail+" = '"+uname +"' AND "+columnPassword+" = '"+pass+"'";  
        try {
            ResultSet rs ;
            Connection conn = dbConn();
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            System.out.println(rs);
            return rs; 
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }
    
    public Boolean deleteData(String table,String column, String email) {
        try {
            Connection conn = dbConn();
            Statement st = conn.createStatement();
            String query = "DELETE FROM "+table+" WHERE "+column+"='" + email + "'";            
            st.executeUpdate(query);
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }     
    }
    
    public ResultSet checkEmail(String table,String column, String email){
        String query = "SELECT * FROM "+table+" where "+column+"='" + email + "'";
        try {
            ResultSet rs ;
            Connection conn = dbConn();
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            System.out.println(rs);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }
    
    public Boolean updateData(String table, String Fnameval, String Mnameval,String Lnameval,String Emailval,String Userval,String pswrd,String id) {
        try {
            Connection conn = dbConn();
            Statement st = conn.createStatement();
            String query = "UPDATE "+table+" SET `First_Name`='" + Fnameval + "',`Middle_Name`='" + Mnameval + "',`Last_Name`='" + Lnameval + "',`EMail`='" + Emailval + "',`UserName`='" + Userval + "',`Password`='" + pswrd + "' WHERE id = '" + id + "'";
            System.out.println(query);
            st.executeUpdate(query);
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }     
    }
    
    
}

