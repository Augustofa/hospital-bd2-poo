package com.iftm.gerenciadorhospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "#Nathalia3101");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
