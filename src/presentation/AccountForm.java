package presentation;

import datalayer.AccountDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccountForm extends JFrame{

    private String firstName;
    private String lastName;
    private String street;
    private String houseNumber;
    private String houseNumberAddition;
    private String residence;

    private javax.swing.JPanel JPanel;
    private JTextField firstNameTextField;
    private JTextField StreetTextField;
    private JTextField HouseNumberTextField;
    private JTextField HouseNumberAdditionTextField;
    private JTextField ResidenceTextField;
    private JButton createNewAccountButton;
    private JTextField lastNameTextField;

    public AccountForm() {
        // Set button attributes (purely Aesthetic)
        createNewAccountButton.setBorderPainted(false);
        createNewAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add main panel with all its contents
        add(JPanel);

        // Set the title and height and width of the form
        setTitle("Create new account");
        setSize(400,300);

        // When form opens center it in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        // This action happens when the "Create new Account" button is pressed
        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get the text from the textfield and assign it to the right value
                firstName = firstNameTextField.getText();
                lastName = lastNameTextField.getText();
                street = StreetTextField.getText();
                houseNumber = HouseNumberTextField.getText();
                houseNumberAddition = HouseNumberAdditionTextField.getText();
                residence = ResidenceTextField.getText();

                boolean succesfull = new AccountDAO().createAccount(firstName, lastName, street, houseNumber, houseNumberAddition, residence);
                if(succesfull){
                    JOptionPane.showMessageDialog(null,"Succesfully created account!");

                    // Disposes the window if succesfull
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Failed creating account, please check if all values are filled in correctly");
                }

            }
        });

        createNewAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                createNewAccountButton.setBackground(Color.red);
            }
        });
        createNewAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                createNewAccountButton.setBackground(new Color(229, 9, 20));
            }
        });
    }
}
