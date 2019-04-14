package datalayer;

import domain.Profile;

import java.util.ArrayList;

public class ProfileDAO {

    public ProfileDAO() {
    }

    public ArrayList<Profile> getAllProfiles(int accountID) {
        ArrayList<Profile> profilesList = new DatabaseConnection().getAllProfiles(accountID);
        return profilesList;
    }
}

