package UI;

import datalayer.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

    private javax.swing.JPanel JPanel;
    private JTabbedPane tabbedPanel;
    private JButton testConnectionButton;
    private JButton addAccountButton;
    private JLabel testConnectionLabel;

    public MainForm() {
        add(JPanel);
        add(tabbedPanel);

        setTitle("Netflix Statistix");
        setSize(700,400);

        // When form opens center it in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        testConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean connectionSuccesfull = new DatabaseConnection().openConnection();
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
}