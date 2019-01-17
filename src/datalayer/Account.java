package datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class Account {

    //Function to create a account
    public void createAccount(String name, String street, String houseNumber, String houseNumberAddition, String residence) {

        // Setup the connection
        Connection conn = DatabaseConnection.getInstance().connect();

        // Surround with try/catch to handle any exceptions
        try {
            // Defining you want to create a statement
            Statement st = conn.createStatement();

            // The SQL that needs to be executed
            String SQL = "INSERT INTO Account(Name, Street, HouseNumber, HouseNumberAddition, Residence) VALUES ('" + name + "','" + street + "','" + houseNumber + "','" + houseNumberAddition + "','" + residence + "')";
            // Execute the Query
            st.executeQuery(SQL);
        } catch (SQLException e) {

            // This error will be shown when something goes wrong with creating an account
            System.out.println("Error inserting Account");
        }finally {
            try {
                // And finally close the connection with the database
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    // Function to get all accounts
//    public Set<Account> getAllAccounts() {
//
//        HashSet<Account> accounts = new HashSet();
//        Connection conn = DatabaseConnection.getInstance().connect();
//
//        try {
//            Statement st = conn.createStatement();
//            String SQL = "SELECT * FROM dbo.Account";
//            ResultSet result = st.executeQuery(SQL);
//
//            while (result.next()) {
//                Account ac = new Account(
//                        result.getString("Name")
//                );
//
//                accounts.add(ac);
//            }
//        } catch (
//                SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return accounts;
//    }
}
