package datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Account {

    private DatabaseConnection conn;

    public Account() {
        // Initiate the connection to the database
        conn = new DatabaseConnection();
    }

    //Function to create a account
    public boolean createAccount(String name, String street, String houseNumber, String houseNumberAddition, String residence) {

        String query = "INSERT INTO Account(Name, Street, HouseNumber, HouseNumberAddition, Residence) VALUES ('" + name + "','" + street + "','" + houseNumber + "','" + houseNumberAddition + "','" + residence + "')";
        boolean successfull = conn.executeInsertQuery(query);
        conn.closeConnection();
        if (successfull) {
            return true;
        } else {
            return false;
        }

    }

    // Function to get all accounts
    public ArrayList<Account> getAllAccounts() {

        ArrayList<Account> accounts = new ArrayList<>();

        String query = "SELECT * FROM Account";
        ResultSet resultSet = conn.executeSelectQuery(query);
        try {
            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getString("Name"),
                        resultSet.getString("Street"),
                        resultSet.getString("HouseNumber"),
                        resultSet.getString("HouseNumberAddition"),
                        resultSet.getString("Residence")
                        );
            }

            conn.closeConnection();

            return accounts;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
