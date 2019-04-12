package presentation;

import domain.Account;
import domain.Exercise1;
import domain.Movie;
import domain.Serie;
import datalayer.AccountDAO;
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
    private JTable table3;
    private JTextField task1seriename;
    private JTextField task2seriename;
    private JTextField task2profileid;
    private JTextField textField4;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public MainForm(String profile) {

        // Add components
        add(JPanel);
        add(tabbedPanel);

        // Set attributes
        setTitle("Netflix statistix - Current profile: " + profile);
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));

        // Fill tables
        fillMoviesTable();
        fillSeriesTable();


        // When form opens center it in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        testConnectionButton.addActionListener(e -> {
            Boolean connectionSuccesfull = new DatabaseConnection().testConnection();
            if (connectionSuccesfull) {
                testConnectionLabel.setText("Connected!");
            } else {
                testConnectionLabel.setText("Failed..");
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
        ArrayList<Exercise1> exercise1 = new SerieDAO().getTask1(task1seriename.getText());
        String[] col = {"SerieTitle", "EpisodeNr", "WatchedPercentage"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        task1Table.setModel(tableModel);

        for (Exercise1 exercise1S : exercise1) {
            String serieTitle = exercise1S.getSerieTitle();
            String episodeNr = exercise1S.getEpisodeNr();
            String watchedPercentage = exercise1S.getWatchedPercentage();

            Object[] excerise1Data = {serieTitle, episodeNr, watchedPercentage};

            tableModel.addRow(excerise1Data);
        }
    }
    private void fillTask2() {
        ArrayList<Exercise1> exercise1 = new SerieDAO().getTask2(task2seriename.getText(), task2profileid.getText());
        String[] col = {"SerieTitle", "EpisodeNr", "WatchedPercentage"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        task2Table.setModel(tableModel);

        for (Exercise1 exercise1S : exercise1) {
            String serieTitle = exercise1S.getSerieTitle();
            String episodeNr = exercise1S.getEpisodeNr();
            String watchedPercentage = exercise1S.getWatchedPercentage();

            Object[] excerise2Data = {serieTitle, episodeNr, watchedPercentage};

            tableModel.addRow(excerise2Data);
        }
    }

}