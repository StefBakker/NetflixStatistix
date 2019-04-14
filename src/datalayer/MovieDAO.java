package datalayer;


import domain.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {
    public MovieDAO() {
    }

    // Function to get all movies
    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> moviesList = new ArrayList<>();
        String query = "SELECT * FROM dbo.Movie";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                Movie movies = new Movie(
                        resultSet.getString("ProgramTitle"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Language"),
                        resultSet.getString("AgeIndication")
                );
                moviesList.add(movies);
            }
            return moviesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}