/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getConnection() throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=QuanLyMayTinh;"
                + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";  
        String username = "demo";
        String password = "minmin";
        Connection con = DriverManager.getConnection(connectionUrl,username,password);
        System.out.println("Connected");
        return con;
    }
}
