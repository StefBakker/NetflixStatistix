package presentation;

import datalayer.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame {

    private JPanel mainPanel;
    private JPanel loginPanel;
    private JTextField userNameField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel enterYourName;
    private JLabel NetflixLogo;
    private ImageIcon image;

    public LoginForm() {

        // Sets the look and feel of the program to WindowsClassic
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (Exception e){

        }

        // Add compontents
        add(mainPanel);


        // Set button attributes (purely Aesthetic)
        registerButton.setBorderPainted(false);
        loginButton.setBorderPainted(false);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginButton.setBackground(Color.red);
            }
        });

        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                registerButton.setBackground(Color.red);
            }
        });
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginButton.setBackground(new Color(229, 9, 20));
            }
        });

        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                registerButton.setBackground(new Color(229, 9, 20));
            }
        });

        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }
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
