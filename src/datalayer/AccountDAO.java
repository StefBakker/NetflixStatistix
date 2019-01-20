package datalayer;

import Domain.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
        }else{
            System.out.println("No database connection!");
        }
        return false;
    }
     // Function to get all accounts
    public Set<Account> getAllAccounts() {

        ResultSet resultSet = null;
        Set<Account> accountDAOS = new HashSet<>();

        String query = "SELECT * FROM dbo.Account";
        resultSet = conn.executeSelectQuery(query);

        if(resultSet != null){
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

                return accountDAOS;
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        //resultSet = conn.executeSelectQuery(query);


        return null;
    }
}
