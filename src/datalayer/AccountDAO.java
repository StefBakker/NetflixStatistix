package datalayer;

import Domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDAO {

    private DatabaseConnection conn;

    private Statement statement;

    public AccountDAO() {
        // Initiate the connection to the database
        conn = new DatabaseConnection();
    }

    //Function to create a account
    public boolean createAccount(String name, String street, String houseNumber, String houseNumberAddition, String residence) {

        String query = "INSERT INTO Account(Name, Street, HouseNumber, HouseNumberAddition, Residence) VALUES ('" + name + "','" + street + "','" + houseNumber + "','" + houseNumberAddition + "','" + residence + "')";
        if (conn.openConnection()) {

            boolean successfull = conn.executeInsertQuery(query);

            conn.closeConnection();
            if (successfull) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("No database connection!");
        }
        return false;
    }

    // Function to get all accounts
    public ArrayList<Account> getAllAccounts() {
        ArrayList<Account> accountsList = new ArrayList<>();

        if (conn.openConnection()) {
            String query = "SELECT * FROM dbo.Account";

            ResultSet resultSet = conn.executeSelectQuery(query);

            try {
                while (resultSet.next()) {
                    Account accounts = new Account(
                            resultSet.getString("Name"),
                            resultSet.getString("Street"),
                            resultSet.getString("HouseNumber"),
                            resultSet.getString("HouseNumberAddition"),
                            resultSet.getString("Residence")
                    );
                    accountsList.add(accounts);
                }
                conn.closeConnection();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }
}
