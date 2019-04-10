package datalayer;

import Domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDAO {


    public AccountDAO() {

    }

    //Function to create a account
    public boolean createAccount(String name, String street, String houseNumber, String houseNumberAddition, String residence) {
        String query = "INSERT INTO Account(Name, Street, HouseNumber, HouseNumberAddition, Residence) VALUES ('" + name + "','" + street + "','" + houseNumber + "','" + houseNumberAddition + "','" + residence + "')";
        Boolean successfull = new DatabaseConnection().setDataToTable(query);
        if (successfull) {
            System.out.println("Succesfully created account!");
        } else {
            System.out.printf("Creating account failed!");
        }
        return successfull;
    }

    // Function to get all accounts
    public ArrayList<Account> getAllAccounts() {
        ArrayList<Account> accountsList = new ArrayList<>();
        String query = "SELECT * FROM dbo.Account";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountsList;
    }
}
