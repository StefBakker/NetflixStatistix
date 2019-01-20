package UI;

import Domain.Account;
import Domain.Movie;
import datalayer.AccountDAO;
import datalayer.DatabaseConnection;
import datalayer.MovieDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class MainForm extends JFrame {

    private javax.swing.JPanel JPanel;
    private JTabbedPane tabbedPanel;
    private JButton testConnectionButton;
    private JButton addAccountButton;
    private JLabel testConnectionLabel;
    private JTable accountsTable;
    private JTable moviesTable;

    public MainForm() {
        add(JPanel);
        add(tabbedPanel);

        setTitle("Netflix Statistix");
        setSize(700, 400);

        // Fill tables
        fillAccountsTable();
        fillMoviesTable();

        // When form opens center it in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        testConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DatabaseConnection().openConnection();
//                if(connectionSuccesfull){
//                    testConnectionLabel.setText("Connected!");
//                }else{
//                    testConnectionLabel.setText("Failed..");
//                }
            }
        });
        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountForm af = new AccountForm();
                af.setVisible(true);
            }
        });
    }

    private void fillMoviesTable() {
        ArrayList<MovieDAO> movies = new MovieDAO().getAllMovies();
        ArrayList<String> columns = new ArrayList<String>();

        columns.add("Name");
        columns.add("Genre");
        columns.add("Language");
        columns.add("Age Indication");

        if(movies != null){
            TableModel tableModel = new DefaultTableModel(movies.toArray(new Object[][] {}), columns.toArray());
            JTable table = moviesTable;
            table.setModel(tableModel);
        }else{
            System.out.println("No movies found ?");
        }

    }

    public void fillAccountsTable() {
        Set<Account> accounts = new AccountDAO().getAllAccounts();

        ArrayList<String> columns = new ArrayList<String>();
       // ArrayList<String[]> values = new ArrayList<String[]>();

        columns.add("Name");
        columns.add("Street");
        columns.add("Profiles");

//        for (int i = 0; i < 10; i++) {
//            values.add(new String[] {"val"+i+" Name","val"+i+" Street","val"+i+" Profiles"});
//        }

        if(accounts != null){
            TableModel tableModel = new DefaultTableModel(accounts.toArray(new Object[][] {}), columns.toArray());
            JTable table = accountsTable;
            table.setModel(tableModel);
        }else{
            System.out.println("No accounts found?");
        }
    }

}