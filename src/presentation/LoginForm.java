package presentation;

import datalayer.DatabaseConnection;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    private JPanel mainPanel;
    private JPanel loginPanel;
    private JTextField userNameField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginForm() {

        // Add compontents
        add(mainPanel);

        // Set windows attributes
        setBackground(Color.black);
        setTitle("Netflix Statistix");
        setSize(700,300);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));
        centerFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Register button actionlistener
        registerButton.addActionListener(e -> {
            RegisterForm registerForm = new RegisterForm();
            registerForm.setVisible(true);
        });

        // Login button actionlistener
        loginButton.addActionListener(e -> {
            if(!userNameField.getText().isEmpty()){
                String userName = userNameField.getText();
                Boolean userFound = new DatabaseConnection().checkIfUserExists(userName);
                if (userFound){
                    dispose();

                   // TODO add userID getter so that every account gets its own profiles, it is now set to an already existing account in the database

                    // Aka where now stands "1011" there has to go the userID.
                    //int userID = 1011;
                    int userID = new DatabaseConnection().getAccountID(userName);
                    ProfileForm profileForm = new ProfileForm(userID);
                    profileForm.setVisible(true);
                }else{
                    System.out.println("User not found");
                    JOptionPane.showMessageDialog(null, "Username not found!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please enter a username:");
            }

        });
    }

    // Method to center the form
    private void centerFrame() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }
}
