package com.example.sms_java.db;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
    // Database connection parameters

    private static final Properties props = new Properties();

    static {
        try (InputStream is = DatabaseConnection.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (is == null) {
                throw new RuntimeException("db.properties not found");
            }
            props.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB config", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password")
            );
        } catch (Exception e) {
            throw new RuntimeException("DB connection failed", e);
        }
    }

//    // Static method to establish a database connection
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//    }

    // Static method to close a database connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Static method to close a PreparedStatement
    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Static method to close a ResultSet
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
