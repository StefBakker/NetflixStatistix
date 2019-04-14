package presentation;

import datalayer.ProfileDAO;
import domain.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class ProfileForm extends JFrame {
    private JPanel mainPanel;
    private JPanel profilePanel;
    private JPanel profileImagePanel;
    private int accountID;

    public ProfileForm(int accountId) {
        this.accountID = accountId;
        // Add components
        add(mainPanel);
        add(profilePanel);

        // Set form attributes
        getProfilesForAccount(accountId);
        setTitle("Netflix Statistix - Choose profile");
        setSize(600, 300);
        setResizable(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the frame
        centerFrame();
    }


    // Function to get all profiles for a give account
    private void getProfilesForAccount(int accountID) {

        // Create arraylist
        ArrayList<Profile> profiles = new ProfileDAO().getAllProfiles(accountID);

        // For each profile found in profiles create a button in the profile panel on profileform
        for (Profile profile : profiles) {

            // Sets the profile image
            Random randomGenerator = new Random();
            int profileImageId = randomGenerator.nextInt(9) + 1;
            ImageIcon image = new ImageIcon("images/Profile" + profileImageId + ".png");
            JLabel label = new JLabel("", image, JLabel.CENTER);


            // Create new button
            JButton btn = new JButton();
            btn.setBorderPainted(false);
            btn.setBackground(new Color(229, 9, 20));
            btn.setForeground(Color.WHITE);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.setFocusPainted(false);

            // Set the button text with the given profilename
            btn.setText(profile.getName());


            // Create an actionListener to open next form
            btn.addActionListener(e -> {
                dispose();
                MainForm mainForm = new MainForm(profile.getName(), accountID);
                mainForm.setVisible(true);
            });

            // This listener changes the color of the button when user hover over it
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    btn.setBackground(Color.red);
                }
            });

            // This listener changes the color of the button back to it's original color
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    btn.setBackground(new Color(229, 9, 20));
                }
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
