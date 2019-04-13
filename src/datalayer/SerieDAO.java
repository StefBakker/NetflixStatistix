package datalayer;

import domain.*;

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
    public ArrayList<ExercisegetPercentage> getTask1(String input1) {
        ArrayList<ExercisegetPercentage> task1 = new ArrayList<>();
        String query =
                "SELECT SerieTitle, EpisodeNr, AVG(WatchedPrograms.WatchedPercentage) AS WatchedPercentage\n" +
                        "FROM Episode\n" +
                        "JOIN WatchedPrograms ON Episode.ProgramTitle=WatchedPrograms.ProgramTitle\n" +
                        "AND SerieTitle = '"+input1+"'\n" +
                        "GROUP BY SerieTitle, EpisodeNr;";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                ExercisegetPercentage exercisegetPercentage = new ExercisegetPercentage(
                        resultSet.getString("SerieTitle"),
                        resultSet.getString("EpisodeNr"),
                        resultSet.getString("WatchedPercentage")
                );
                task1.add(exercisegetPercentage);
            }
            return task1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ExercisegetPercentage> getTask2(String task2Serie, String task2Profile) {

        ArrayList<ExercisegetPercentage> task2 = new ArrayList<>();
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
                ExercisegetPercentage exercisegetPercentage = new ExercisegetPercentage(
                        resultSet.getString("SerieTitle"),
                        resultSet.getString("EpisodeNr"),
                        resultSet.getString("WatchedPercentage")
                );
                task2.add(exercisegetPercentage);
            }
            return task2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Exercise3> getTask3(String task3Profile) {

        ArrayList<Exercise3> task3 = new ArrayList<>();
        String query =
                "SELECT ProgramTitle\n" +
                        "FROM WatchedPrograms\n" +
                        "WHERE WatchedPercentage = 100 and ProfileID = "+task3Profile;
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                Exercise3 exercise3 = new Exercise3(
                        resultSet.getString("ProgramTitle")
                );
                task3.add(exercise3);
            }
            return task3;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Exercise4> getTask4() {

        ArrayList<Exercise4> task4 = new ArrayList<>();
        String query =
                "SELECT TOP 1 Title, Duration\n" +
                        "FROM Program\n" +
                        "INNER JOIN Movie\n" +
                        "ON Program.Title = Movie.ProgramTitle\n" +
                        "WHERE Movie.AgeIndication < 16\n" +
                        "ORDER BY Program.Duration desc";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                Exercise4 exercise4 = new Exercise4(
                        resultSet.getString("Title"),
                        resultSet.getString("Duration")
                );
                task4.add(exercise4);
            }
            return task4;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Exercise5> getTask5() {

        ArrayList<Exercise5> task5 = new ArrayList<>();
        String query =
                "SELECT Account.firstName\n" +
                        "FROM Account\n" +
                        "JOIN Profile ON Account.ID = Profile.AccountID\n" +
                        "GROUP BY Account.firstName\n" +
                        "HAVING COUNT(Profile.AccountID) <= 1";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                Exercise5 exercise5 = new Exercise5(
                        resultSet.getString("firstName")
                );
                task5.add(exercise5);
            }
            return task5;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Exercise6> getTask6(String filmname) {

        ArrayList<Exercise6> task6 = new ArrayList<>();
        String query =
                "SELECT COUNT(ProgramTitle) as Amount\n" +
                        "FROM WatchedPrograms\n" +
                        "WHERE WatchedPercentage >= 100 and ProgramTitle = '"+filmname+"'";
        ResultSet resultSet = new DatabaseConnection().getAllFromTable(query);
        try {
            while (resultSet.next()) {
                Exercise6 exercise6 = new Exercise6(
                        resultSet.getString("Amount")
                );
                task6.add(exercise6);
            }
            return task6;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

