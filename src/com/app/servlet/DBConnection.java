package com.app.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://root:xwbejyfHgPBSnGovcUsqskIvYvaxyzpr@nozomi.proxy.rlwy.net:45865/railway";
        String user = "root";
        String password = "xwbejyfHgPBSnGovcUsqskIvYvaxyzpr"; // ⚠️ change this

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, user, password);
    }
}