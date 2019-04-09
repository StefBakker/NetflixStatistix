package datalayer;


import Domain.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {

    private DatabaseConnection conn;

    public MovieDAO() {
        // The connection string to the database
        conn = new DatabaseConnection();
    }

    public ArrayList<MovieDAO> movies(int filmID) {

        ArrayList<MovieDAO> movieDAOS = new ArrayList<>();

        String query = "SELECT * FROM Movie";
        ResultSet resultSet = conn.executeSelectQuery(query);
        try {
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getString("ProgramTitle"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Language"),
                        resultSet.getString("AgeIndication")
                );
            }

            conn.closeConnection();

            return movieDAOS;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<MovieDAO> getAllMovies() {
        ArrayList<Movie> moviesList = new ArrayList<>();

        if (conn.openConnection()) {
            String query = "SELECT * FROM dbo.Movie";

            ResultSet resultSet = conn.executeSelectQuery(query);

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
                conn.closeConnection();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }
}
