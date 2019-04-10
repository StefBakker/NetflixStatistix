package presentation;

import datalayer.AccountDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountForm extends JFrame{

    private String name;
    private String street;
    private String houseNumber;
    private String houseNumberAddition;
    private String residence;

    private javax.swing.JPanel JPanel;
    private JTextField NameTextField;
    private JTextField StreetTextField;
    private JTextField HouseNumberTextField;
    private JTextField HouseNumberAdditionTextField;
    private JTextField ResidenceTextField;
    private JButton createNewAccountButton;

    public AccountForm() {

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
                name = NameTextField.getText();
                street = StreetTextField.getText();
                houseNumber = HouseNumberTextField.getText();
                houseNumberAddition = HouseNumberAdditionTextField.getText();
                residence = ResidenceTextField.getText();

                boolean succesfull = new AccountDAO().createAccount(name, street, houseNumber, houseNumberAddition, residence);
                if(succesfull){
                    JOptionPane.showMessageDialog(null,"Succesfully created account!");

                    // Disposes the window if succesfull
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Failed creating account, please check if all values are filled in correctly");
                }

            }
        });
    }
}
