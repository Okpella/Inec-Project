package com.prof.inec.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;

    public static Connection getConnection() throws SQLException{
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inec",
                        "root", "okpella1");

                return connection;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
