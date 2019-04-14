package presentation;

import domain.*;
import datalayer.DatabaseConnection;
import datalayer.MovieDAO;
import datalayer.SerieDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm extends JFrame {

    private javax.swing.JPanel JPanel;
    private JTabbedPane tabbedPanel;
    private JButton testConnectionButton;
    private JLabel testConnectionLabel;
    private JTable accountsTable;
    private JTable moviesTable;
    private JLabel JLabelProgram;
    private JLabel JLabelInfo;
    private JTable seriesTable;
    private JTable task1Table;
    private JTable task2Table;
    private JTable task3Table;
    private JTextField task1seriename;
    private JTextField task2seriename;
    private JTextField task2profileid;
    private JTextField task3profileid;
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JTable task4Table;
    private JTable task5Table;
    private JTable task6Table;
    private JTextField task6filmName;
    private JButton button4;
    private JButton deleteAccountButton;

    public MainForm(String profile, int accountID) {

        // Add components
        add(JPanel);
        add(tabbedPanel);

        // Set attributes
        setTitle("Netflix statistix - Current profile: " + profile);
        setSize(625, 525);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));

        // Fill tables
        fillMoviesTable();
        fillSeriesTable();
        fillTask4();
        fillTask5();

        //Set button attributes
        button1.setFocusPainted(false);
        button2.setFocusPainted(false);
        button3.setFocusPainted(false);
        button4.setFocusPainted(false);
        deleteAccountButton.setFocusPainted(false);
        testConnectionButton.setFocusPainted(false);


        // When form opens center it in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);


        // Actionlisteners

        // Connectionbuttonlistener for testing database connection
        testConnectionButton.addActionListener(e -> {
            Boolean connectionSuccesfull = new DatabaseConnection().testConnection();
            if (connectionSuccesfull) {
                testConnectionLabel.setText("Connected!");
            } else {
                testConnectionLabel.setText("Failed..");
            }
        });
        // Deletebuttonlistener for deleting accounts, closes the application upon deletion
        deleteAccountButton.addActionListener(e -> {
            int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Delete", JOptionPane.YES_NO_OPTION);
            if (opt == 0) {
                Boolean accountDeleteSuccesfull = new DatabaseConnection().deleteAccount(accountID);
                if (accountDeleteSuccesfull) {
                    System.out.println("Something went wrong, account was not deleted.");
                } else {
                    System.out.println("Account was succesfully deleted");
                    System.exit(0);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillTask1();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillTask2();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillTask3();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillTask6();
            }
        });
    }


    // Function to get all the movies and fill the list
    private void fillMoviesTable() {

        // Create Arraylist
        ArrayList<Movie> movies = new MovieDAO().getAllMovies();

        // Add columns
        String[] col = {"Name", "Genre", "Language", "Age Indication"};

        // Create and add a tablemodel
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        moviesTable.setModel(tableModel);

        // For each movie found in movies arraylist add to movies table
        for (Movie movie : movies) {
            String name = movie.getProgramTitle();
            String genre = movie.getGenre();
            String language = movie.getLanguage();
            String ageIndication = movie.getAgeIndication();

            // Create object with movie data
            Object[] movieData = {name, genre, language, ageIndication};

            // Add tablemodel row with the given moviedata
            tableModel.addRow(movieData);
        }

    }

    // Function to get all the series and fill the list
    private void fillSeriesTable() {

        // Create Arraylist
        ArrayList<Serie> series = new SerieDAO().getAllSeries();

        // Add columns
        String[] col = {"Title", "Genre", "Language", "AgeIndication"};

        // Create and add a tablemodel
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        seriesTable.setModel(tableModel);

        // For each serie found in series arraylist add to series table
        for (Serie serie : series) {
            String title = serie.getTitle();
            String genre = serie.getGenre();
            String language = serie.getLanguage();
            String ageIndication = serie.getAgeIndication();

            // Create object with serie data
            Object[] serieData = {title, genre, language, ageIndication};

            // Add tablemodel row with the given moviedata
            tableModel.addRow(serieData);
        }
    }

    private void fillTask1() {
        ArrayList<ExercisegetPercentage> exercisegetPercentage = new SerieDAO().getTask1(task1seriename.getText());
        String[] col = {"SerieTitle", "EpisodeNr", "WatchedPercentage"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        task1Table.setModel(tableModel);

        for (ExercisegetPercentage exercisegetPercentageS : exercisegetPercentage) {
            String serieTitle = exercisegetPercentageS.getSerieTitle();
            String episodeNr = exercisegetPercentageS.getEpisodeNr();
            String watchedPercentage = exercisegetPercentageS.getWatchedPercentage();

            Object[] excerise1Data = {serieTitle, episodeNr, watchedPercentage};

            tableModel.addRow(excerise1Data);
        }
    }

    private void fillTask2() {
        ArrayList<ExercisegetPercentage> exercisegetPercentage = new SerieDAO().getTask2(task2seriename.getText(), task2profileid.getText());
        String[] col = {"SerieTitle", "EpisodeNr", "WatchedPercentage"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        task2Table.setModel(tableModel);

        for (ExercisegetPercentage exercisegetPercentageS : exercisegetPercentage) {
            String serieTitle = exercisegetPercentageS.getSerieTitle();
            String episodeNr = exercisegetPercentageS.getEpisodeNr();
            String watchedPercentage = exercisegetPercentageS.getWatchedPercentage();

            Object[] excerise2Data = {serieTitle, episodeNr, watchedPercentage};

            tableModel.addRow(excerise2Data);
        }
    }

    private void fillTask3() {
        ArrayList<Exercise3> exercise3 = new SerieDAO().getTask3(task3profileid.getText());
        String[] col = {"programTitle"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        task3Table.setModel(tableModel);

        for (Exercise3 exercise3S : exercise3) {
            String programTitle = exercise3S.getProgramTitle();

            Object[] excerise3Data = {programTitle};

            tableModel.addRow(excerise3Data);
        }
    }

    private void fillTask4() {
        ArrayList<Exercise4> exercise4 = new SerieDAO().getTask4();
        String[] col = {"programTitle", "duration"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        task4Table.setModel(tableModel);

        for (Exercise4 exercise4S : exercise4) {
            String programTitle = exercise4S.getProgramTitle();
            String duration = exercise4S.getDuration();

            Object[] excerise4Data = {programTitle, duration};

            tableModel.addRow(excerise4Data);
        }
    }

    private void fillTask5() {
        ArrayList<Exercise5> exercise5 = new SerieDAO().getTask5();
        String[] col = {"firstname"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        task5Table.setModel(tableModel);

        for (Exercise5 exercise5S : exercise5) {
            String firstname = exercise5S.getFirstname();

            Object[] excerise5Data = {firstname};

            tableModel.addRow(excerise5Data);
        }
    }

    private void fillTask6() {
        ArrayList<Exercise6> exercise6 = new SerieDAO().getTask6(task6filmName.getText());
        String[] col = {"amount"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        task6Table.setModel(tableModel);

        for (Exercise6 exercise6S : exercise6) {
            String numberofUsersCompleted = exercise6S.getNumberofUsersCompleted();

            Object[] excerise6Data = {numberofUsersCompleted};

            tableModel.addRow(excerise6Data);
        }
    }
}