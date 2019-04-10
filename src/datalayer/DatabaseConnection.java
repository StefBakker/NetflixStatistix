package datalayer;

import util.ConfigReader;

import java.sql.*;

public class DatabaseConnection {

    private Connection conn;
    private String DatabaseConnectionURL;

    public DatabaseConnection() {

        // Initiate the connection to the database
        DatabaseConnectionURL = new ConfigReader().getConnectionURL();
        try {
            conn = DriverManager.getConnection(DatabaseConnectionURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean setDataToTable(String query) {
        try {
            if (conn.isValid(3)) {
                Statement stmt;

                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                stmt.close();
                conn.close();
                return rs != null;
            } else {
                System.out.println("No database connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public ResultSet getAllFromTable(String query) {
        ResultSet resultSet = null;

        try {
            if (conn.isValid(3)) {
                Statement stmt = null;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                try {
                    resultSet = stmt.executeQuery(query);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean testConnection() {
        try {
            return conn.isValid(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}