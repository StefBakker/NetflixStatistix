package datalayer;

import domain.Exercise1;
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
    public ArrayList<Exercise1> getTask1(String input1) {
        ArrayList<Exercise1> task1 = new ArrayList<>();
        String query =
                "SELECT SerieTitle, EpisodeNr, WatchedPrograms.WatchedPercentage\n" +
                        "FROM Episode\n" +
                        "JOIN WatchedPrograms ON Episode.ProgramTitle=WatchedPrograms.ProgramTitle\n" +
                        "AND SerieTitle = '"+input1+"'";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                Exercise1 exercise1 = new Exercise1(
                        resultSet.getString("SerieTitle"),
                        resultSet.getString("EpisodeNr"),
                        resultSet.getString("WatchedPercentage")
                );
                task1.add(exercise1);
            }
            return task1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Exercise1> getTask2(String task2Serie, String task2Profile) {

        ArrayList<Exercise1> task2 = new ArrayList<>();
        String query =
                "SELECT SerieTitle, EpisodeNr, WatchedPrograms.WatchedPercentage\n" +
                        "FROM Episode\n" +
                        "JOIN WatchedPrograms ON Episode.ProgramTitle=WatchedPrograms.ProgramTitle\n" +
                        "AND SerieTitle = '"+task2Serie+"' AND ProfileID = "+task2Profile;
        System.out.println(
                "SELECT SerieTitle, EpisodeNr, WatchedPrograms.WatchedPercentage\n" +
                        "FROM Episode\n" +
                        "JOIN WatchedPrograms ON Episode.ProgramTitle=WatchedPrograms.ProgramTitle\n" +
                        "AND SerieTitle = '"+task2Serie+"' AND ProfileID = "+task2Profile);
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                Exercise1 exercise1 = new Exercise1(
                        resultSet.getString("SerieTitle"),
                        resultSet.getString("EpisodeNr"),
                        resultSet.getString("WatchedPercentage")
                );
                task2.add(exercise1);
            }
            return task2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

