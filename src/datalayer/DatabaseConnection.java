package datalayer;

import domain.Profile;
import util.ConfigReader;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {

    private Connection conn;
    private String DatabaseConnectionURL;

    // Constructor
    public DatabaseConnection() {

        // Initiate the connection to the database
        DatabaseConnectionURL = new ConfigReader().getConnectionURL();
        try {
            conn = DriverManager.getConnection(DatabaseConnectionURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to set data to a certain table in the databae
    public boolean setDataToTable(String query) {
        try {
            // Check if the connection is valid with an timeout for 3 seconds
            if (conn.isValid(3)) {

                // Create statement
                Statement stmt;
                stmt = conn.createStatement();

                // Execute the statement with the given query
                stmt.executeQuery(query);

                // Close connections
                stmt.close();
                conn.close();
                return true;
            } else {
                // Give error if database isn't connected or found
                System.out.println("No database connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Function to return all data from a table
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

    // Function to check the database connection
    public Boolean testConnection() {

        try {
            return conn.isValid(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Function to check if an user exists in the database and returns a boolean
    public Boolean checkIfUserExists(String userName) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Account WHERE firstName = ?");
            st.setString(1, userName);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                //System.out.println("Found!");
                return true;
            } else {
                //System.out.println("User doesn't exist");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    // Function to check if an user exists in the database and returns a boolean
    public int getAccountID(String userName) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT ID FROM Account WHERE firstName = ?");
            st.setString(1, userName);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                return r1.getInt("ID");
            } else {
                System.out.println("ID not found");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // Function to retrieve all profiles from the give accountID
    public ArrayList getAllProfiles(int accountID) {
        ArrayList<Profile> profilesList = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Profile WHERE AccountID = ?");
            st.setInt(1, accountID);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Profile profiles = new Profile(
                        resultSet.getString("firstName"),
                        resultSet.getString("DateOfBirth")
                );
                profilesList.add(profiles);
            }
            return profilesList;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return profilesList;
    }

    public boolean deleteAccount(int ID){
        try{
            PreparedStatement st = conn.prepareStatement("DELETE FROM Account WHERE ID = ?");
            st.setInt(1, ID);
            ResultSet resultSet = st.executeQuery();
            return true;
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public Boolean createProfile(String name, int accountID) {
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO Profile (firstName, AccountID) VALUES(?,?)");
            st.setString(1, name);
            st.setInt(2, accountID);
            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("success");
                return true;
            } else {
                System.out.println("stuck somewhere");
                return false;
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int countProfilesOfAccount(int accountID) {
        int counter = 0;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Profile WHERE AccountID=?");
            st.setInt(1, accountID);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("AccountID");

                if(id != 0){
                 counter++;
                }
            }

        }catch (SQLException e){

        }
        return counter;
    }
}