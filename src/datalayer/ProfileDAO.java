package datalayer;

import domain.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfileDAO {

    public ProfileDAO() {
    }

    public ArrayList<Profile> getAllProfiles(){
        ArrayList<Profile> profilesList = new ArrayList<>();
        String query = "SELECT * FROM Profile";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try{
            while (resultSet.next()){
                Profile profiles = new Profile(
                        resultSet.getString("Name"),
                        resultSet.getString("DateOfBirth")
                );
                profilesList.add(profiles);
            }
            return profilesList;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}

