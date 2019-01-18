package datalayer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Serie {
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

    public Serie(){
        conn = new DatabaseConnection();
    }
    public void series(int seriesID) {

        // Setup the connection
        Connection conn = DatabaseConnection.getInstance().connect();

        // Surround with try/catch to handle any exceptions
        try {
            // Defining you want to create a statement
            Statement st = conn.createStatement();
            //ArrayList<String[]> serieGegevens = con.getDataReturnArrayList("SELECT Title, SerieID, Genre, SpokenLanguage, MinAge FROM Serie WHERE SerieID = '" + serieID + "';");
            // The SQL that needs to be executed
            // Someway to import series data from the database
            // Execute the Query
        } catch (SQLException e) {

            // This error will be shown when something goes wrong with creating an account
            System.out.println("Error getting Series");
        } finally {
            try {
                // And finally close the connection with the database
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


