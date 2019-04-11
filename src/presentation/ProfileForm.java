package presentation;

import datalayer.ProfileDAO;
import domain.Profile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProfileForm extends JFrame {
    private JPanel mainPanel;
    private JPanel profilePanel;

    public ProfileForm(int accountId) {
        // Add components
        add(mainPanel);
        add(profilePanel);

        // Set form attributes
        getProfilesForAccount(accountId);
        setTitle("Netflix Statistix - Choose profile");
        setSize(300, 300);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));

        // Center the frame
        centerFrame();
    }


    // Function to get all profiles for a give account
    private void getProfilesForAccount(int accountID) {

        // Create arraylist
        ArrayList<Profile> profiles = new ProfileDAO().getAllProfiles(accountID);

        // For each profile found in profiles create a button in the profile panel on profileform
        for (Profile profile : profiles) {

            // Create new button
            JButton btn = new JButton();

            // Set the button text with the given profilename
            btn.setText(profile.getName());

            // Create an actionListener to open next form
            btn.addActionListener(e -> {
                dispose();
                MainForm mainForm = new MainForm(profile.getName());
                mainForm.setVisible(true);
            });

            // add the button to the profilePanel
            profilePanel.add(btn);
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
