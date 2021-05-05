package com.company;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    String Url = "jdbc:mysql:///kvm?autoReconnect=true&useSSL=false";

    public conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(Url, "root", "");
            s = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
