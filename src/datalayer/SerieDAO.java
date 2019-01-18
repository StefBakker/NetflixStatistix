package datalayer;

import Domain.Account;
import Domain.Serie;

import java.sql.*;
import java.util.ArrayList;

public class SerieDAO {
    private int seriesID;
    private int minAge;
    private String title;
    private String language;
    private String genre;
    private int sharedAmountCompleted;
    private int amountOfEpisodes;

    public int getMinAge() {
        return minAge;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public int getSharedAmountCompleted() {
        return sharedAmountCompleted;
    }

    public int getAmountOfEpisodes() {
        return amountOfEpisodes;
    }

    private DatabaseConnection conn;

    public SerieDAO() {
        // The connection string to the database
        conn = new DatabaseConnection();
    }

    public ArrayList<SerieDAO> series(int seriesID) {

        ArrayList<SerieDAO> serieDAOS = new ArrayList<>();

        String query = "SELECT * FROM Serie";
        ResultSet resultSet = conn.executeSelectQuery(query);
        try {
            while (resultSet.next()) {
                Serie serie = new Serie(
                        resultSet.getString("Title"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Language"),
                        resultSet.getString("AgeIndication")
                );
            }

            conn.closeConnection();

            return serieDAOS;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}

