package datalayer;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Movie {
    private int filmID;
    private int length;
    private String title;
    private int watchedProgress;
    private int minAge;
    private String genre;
    private String language;

    private DatabaseConnection conn;

    public Movie(String title, String genre, String language){
        // The connection string to the database
        conn = new DatabaseConnection();
    }

    public ArrayList<Movie> movies(int filmID) {

        ArrayList<Movie> movies = new ArrayList<>();

        String query = "SELECT * FROM Film";
        ResultSet resultSet = conn.executeSelectQuery(query);
        try {
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getString("Title"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Language")
                );
            }

            conn.closeConnection();

            return movies;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Movie> getAllMovies(){
        ArrayList<Movie> moviesList = new ArrayList<>();

        if(conn.openConnection()){
            String query = "SELECT * FROM Movie";

            ResultSet resultSet = conn.executeSelectQuery(query);

            try{
                while (resultSet.next()){
                    Movie movie = new Movie(
                            resultSet.getString("Name"),
                            resultSet.getString("Genre"),
                            resultSet.getString("AgeIndication")
                    );
                    moviesList.add(movie);
                }
                conn.closeConnection();

            } catch (SQLException e) {
                System.out.println(e);            }
        }
        return null;
    }
}
