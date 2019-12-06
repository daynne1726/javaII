/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author banawancl_sd2081
 */
public class CRUD {

    public Connection connectToDB() {
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/dainedb";
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myUrl, "root", "");
            return connection;
        } catch (Exception e) {
            System.err.println("An error occur!");
            System.err.println(e.getMessage());
            return null;
        }
    }
//insert data to database
    public Boolean insertData(String table , String columns, String values[]) {
        try {
            Connection connection =  connectToDB(); //create connection
            java.sql.Statement statement = connection.createStatement();
            String query = "Insert into " + table + "("+ columns +")values ('" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "','" + values[4] +"','" + values[5] +"','" + values[6] + "','" + values[7] + "')";  
            System.out.println(query);
            statement.executeUpdate(query); //execute query to db
            statement.close(); //disable stmt
            connection.close(); //close db connections
            System.out.println("success") ; 
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return false;
    }

//update data to database
    public boolean updateData(String table, String Fname, String Mname, String Lname, String Email, String pswrd, String uname, String id ) {
        try {
            Connection con = connectToDB();
            java.sql.Statement statement = con.createStatement();
            PreparedStatement pst = con.prepareStatement("update users values(?,?,?,?,?,?) where id=" + id);
            String query = "UPDATE "+table+" SET `First_Name`='" + Fname + "',`Middle_Name`='" + Mname + "',`Last_Name`='" + Lname + "',`EMail`='" + Email + "',`Password`='" + pswrd + "',`UserName`='" + uname + "' WHERE id = '" + id + "'";
            System.out.println(query);
            statement.executeUpdate(query); //execute query to db
            statement.close(); //disable stmt
            con.close(); //close db connections
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    //delete data to database
    public boolean deleteData(String table , String columns, String values[]){
        
        try {
            Connection con = connectToDB();
            java.sql.Statement statement = con.createStatement();  
            String query = "Delete from  " + table + "where ("+ columns +")values ('" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "','" + values[4] + "')";
            System.out.println(query);
            statement.executeUpdate(query); //execute query to db
            statement.close(); //disable stmt
            con.close(); //close db connections
            System.out.println("deleted") ;   
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());     
        }
        return false;
    }



    public ResultSet getData(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = connectToDB();
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
  
//    
//    public static void main(String[] args){
//        Crud c = new Crud();
//        String query = "INSERT INTO `users`(`fname`, `mname`, `lname`, `email`, `password`, `repassw`) VALUES (\"ako\",\"Feliza\",\"Banawan\",\"banawan@gmail.com\",\"admin\",\"admin\")";
//
//        c.insert(query);
//    }
    
}