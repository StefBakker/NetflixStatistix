package presentation;

import datalayer.AccountDAO;
import datalayer.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {

    private JTextField nameTextField;
    private JPanel registrateForm;
    private JTextField StreetTextField;
    private JTextField HouseNumberTextField;
    private JTextField HouseNumberAdditionTextField;
    private JTextField ResidenceTextField;
    private JLabel nameLabel;
    private JButton createButton;

    public RegisterForm() {
        add(registrateForm);
        setBackground(Color.black);
        setSize(300, 300);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));
        centerFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String street = StreetTextField.getText();
            String houseNumber = HouseNumberTextField.getText();
            String houseNumberAddition = HouseNumberAdditionTextField.getText();
            String residence = ResidenceTextField.getText();

            Boolean createAccount = new AccountDAO().createAccount(name,street,houseNumber,houseNumberAddition,residence);
            if(createAccount){
                System.out.println("Account created!");
                dispose();
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
