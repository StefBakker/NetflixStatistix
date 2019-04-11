package presentation;

import datalayer.AccountDAO;

import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JFrame {

    private JTextField firstNameTextField;
    private JPanel registrateForm;
    private JTextField StreetTextField;
    private JTextField HouseNumberTextField;
    private JTextField HouseNumberAdditionTextField;
    private JTextField ResidenceTextField;
    private JLabel nameLabel;
    private JButton createButton;
    private JTextField lastNameTextField;

    public RegisterForm() {
        add(registrateForm);
        setBackground(Color.black);
        setSize(300, 400);
        setTitle("Registrate account");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));
        centerFrame();

        createButton.addActionListener(e -> {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String street = StreetTextField.getText();
            String houseNumber = HouseNumberTextField.getText();
            String houseNumberAddition = HouseNumberAdditionTextField.getText();
            String residence = ResidenceTextField.getText();

            Boolean createAccount = new AccountDAO().createAccount(firstName, lastName, street,houseNumber,houseNumberAddition,residence);
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
