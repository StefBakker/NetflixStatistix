package presentation;

import domain.Account;
import domain.Movie;
import domain.Serie;
import datalayer.AccountDAO;
import datalayer.DatabaseConnection;
import datalayer.MovieDAO;
import datalayer.SerieDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainForm extends JFrame {

    private javax.swing.JPanel JPanel;
    private JTabbedPane tabbedPanel;
    private JButton testConnectionButton;
    private JButton addAccountButton;
    private JLabel testConnectionLabel;
    private JTable accountsTable;
    private JTable moviesTable;
    private JLabel JLabelProgram;
    private JLabel JLabelInfo;
    private JTable seriesTable;

    public MainForm() {
        add(JPanel);
        add(tabbedPanel);

        // Fill tables
        fillAccountsTable();
        fillMoviesTable();
        fillSeriesTable();
        setSize(700,300);

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
        addAccountButton.addActionListener(e -> {
            AccountForm af = new AccountForm();
            af.setVisible(true);
        });
    }

    private void fillMoviesTable() {
        ArrayList<Movie> movies = new MovieDAO().getAllMovies();
        String[] col = {"Name", "Genre", "Language", "Age Indication"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        moviesTable.setModel(tableModel);

        for (Movie movie : movies) {
            String name = movie.getProgramTitle();
            String genre = movie.getGenre();
            String language = movie.getLanguage();
            String ageIndication = movie.getAgeIndication();

            Object[] movieData = {name, genre, language, ageIndication};

            tableModel.addRow(movieData);
        }

    }

    private void fillSeriesTable(){
        ArrayList<Serie> series = new SerieDAO().getAllSeries();
        String[] col = {"Title", "Genre", "Language", "AgeIndication"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        seriesTable.setModel(tableModel);

        for (Serie serie : series){
            String title = serie.getTitle();
            String genre = serie.getGenre();
            String language = serie.getLanguage();
            String ageIndication = serie.getAgeIndication();

            Object[] serieData = {title, genre, language, ageIndication};

            tableModel.addRow(serieData);
        }

    }

    public void fillAccountsTable() {
        ArrayList<Account> accounts = new AccountDAO().getAllAccounts();
        String[] col = {"Name", "Street"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        accountsTable.setModel(tableModel);

        for (Account account : accounts) {
            String name = account.getFirstName();
            String street = account.getStreet();

            Object[] accountData = {name, street};

            tableModel.addRow(accountData);
        }

    }

}