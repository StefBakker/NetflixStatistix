package domain;

import datalayer.DatabaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MainForm extends JFrame {

    private javax.swing.JPanel JPanel;
    private JTabbedPane tabbedPanel;
    private JButton testButton;
    private JButton addAccountButton;

    public MainForm() {
        add(JPanel);
        add(tabbedPanel);

        setTitle("Netflix Statistix");
        setSize(700,400);

        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = DatabaseConnection.getInstance().connect();
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
}