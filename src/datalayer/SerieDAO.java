package datalayer;

import domain.Serie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SerieDAO {

    public SerieDAO() {
    }

    public ArrayList<Serie> getAllSeries() {
        ArrayList<Serie> seriesList = new ArrayList<>();
        String query = "SELECT * FROM Serie";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                Serie series = new Serie(
                        resultSet.getString("Title"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Language"),
                        resultSet.getString("AgeIndication")
                );
                seriesList.add(series);
            }
            return seriesList;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}

