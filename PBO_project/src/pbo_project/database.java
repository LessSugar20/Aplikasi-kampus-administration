/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_project;

import java.sql.Connection;
import java.sql.*;
/**
 *
 * @author boytr
 */
public class database {
    public static Connection conectDb(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
             
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/studentdata","root","");
            return connect;
        }catch(Exception e ){e.printStackTrace();}
        return null;
    }
}
