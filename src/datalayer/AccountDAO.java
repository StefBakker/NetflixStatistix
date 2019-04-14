package datalayer;

public class AccountDAO {


    public AccountDAO() {

    }

    //Function to create a account
    public boolean createAccount(String name, String lastname, String street, String houseNumber, String houseNumberAddition, String residence) {

        // Create a query string with the information needed for creating an account
        String query = "INSERT INTO Account(firstName, lastName, Street, HouseNumber, HouseNumberAddition, Residence) VALUES ('" + name + "','" + lastname + "','" + street + "''" + houseNumber + "','" + houseNumberAddition + "','" + residence + "')";

        // Create boolean to check if account is created
        Boolean successfull = new DatabaseConnection().setDataToTable(query);
        if (successfull) {
            System.out.println("Succesfully created account!");
        } else {
            System.out.printf("Creating account failed!");
        }

        // Returns the boolean
        return successfull;
    }
}
