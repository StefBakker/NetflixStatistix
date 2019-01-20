package datalayer;

import util.ConfigReader;

import java.sql.*;

public class DatabaseConnection {

    private Connection connection;
    private Statement statement;

    private String connectionConfig;

    public DatabaseConnection() {
        connection = null;
        statement = null;

        connectionConfig = ConfigReader.getInstance().getConnectionURL();
    }

    public boolean openConnection() {
        boolean result = false;

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(connectionConfig);

                if (connection != null) {
                    statement = connection.createStatement();
                }

                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        } else {
            result = true;
        }
        return result;
    }

    public boolean isConnected() {
        boolean connected = false;

        if (connection != null && statement != null) {
            return true;
        } else {
            return false;
        }
    }

    public void closeConnection() {
        try {
            statement.close();

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet executeSelectQuery(String query) {
        ResultSet result = null;

        if (query != null) {
            try {
                result = statement.executeQuery(query);
            } catch (Exception e) {
                System.out.println(e);
                result = null;
            }
        }

        return result;
    }

    public boolean executeInsertQuery(String query) {
        boolean result = false;

        if (query != null) {
            try {
                statement.executeUpdate(query);
                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        }
        return result;
    }
}