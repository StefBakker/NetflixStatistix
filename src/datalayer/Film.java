package datalayer;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Film {
    private int filmID;
    private int length;
    private String title;
    private int watchedProgress;
    private int minAge;
    private String genre;
    private String language;

    private DatabaseConnection conn;

    public Film(String title, String genre, String language){
        // The connection string to the database
        conn = new DatabaseConnection();
    }

    public ArrayList<Film> films(int filmID) {

        ArrayList<Film> films = new ArrayList<>();

        String query = "SELECT * FROM Film";
        ResultSet resultSet = conn.executeSelectQuery(query);
        try {
            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getString("Title"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Language")
                );
            }

            conn.closeConnection();

            return films;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
