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
    private JOptionPane jOptionPane;

    public LoginForm() {
        add(mainPanel);

        setBackground(Color.black);
        setTitle("Netflix Statistix");
        setSize(700,300);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));
        centerFrame();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerButton.addActionListener(e -> {
            RegisterForm registerForm = new RegisterForm();
            registerForm.setVisible(true);
        });
        loginButton.addActionListener(e -> {
            if(!userNameField.getText().isEmpty()){
                Boolean userFound = new DatabaseConnection().checkIfUserExists(userNameField.getText());
                if (userFound){
                    dispose();
                    MainForm mainForm = new MainForm();
                    mainForm.setVisible(true);
                }else{
                    System.out.println("User not found");
                    JOptionPane.showMessageDialog(null, "Username not found!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please enter a username:");
            }

        });
    }

    private void centerFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }
}
