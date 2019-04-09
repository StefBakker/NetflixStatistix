package datalayer;

import Domain.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfileDAO {
    private DatabaseConnection conn;

    public ProfileDAO(DatabaseConnection conn) {
        conn = new DatabaseConnection();
    }

    public ArrayList<ProfileDAO> profiles() {
        ArrayList<ProfileDAO> profileDAOS = new ArrayList<>();

        String query = "SELECT * FROM Profile";
        ResultSet resultSet = conn.executeSelectQuery(query);
        try {
            while (resultSet.next()) {
                Profile profile = new Profile(
                        resultSet.getString("Name"),
                        resultSet.getString("DateOfBirth")
                );
            }
            conn.closeConnection();
            return profileDAOS;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}

