package presentation;

import datalayer.AccountDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        // Set button attributes (purely Aesthetic)
        createButton.setBorderPainted(false);
        createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        //Set windows attributes
        add(registrateForm);
        setBackground(Color.black);
        setSize(300, 400);
        setTitle("Register account");
        setResizable(false);

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

        createButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                createButton.setBackground(Color.red);
            }
        });
        createButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                createButton.setBackground(new Color(229, 9, 20));
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
