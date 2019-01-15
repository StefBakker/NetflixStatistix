package domain;

import datalayer.DatabaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class MainForm extends JFrame {

    private javax.swing.JPanel JPanel;
    private JTabbedPane tabbedPanel;
    private JButton testButton;

    public MainForm() {
        add(JPanel);
        add(tabbedPanel);

        setTitle("Netflix Statistix");
        setSize(400,400);

        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = DatabaseConnection.getInstance().connect();
            }
        });
    }
}