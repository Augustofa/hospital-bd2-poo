package com.iftm.gerenciadorhospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
