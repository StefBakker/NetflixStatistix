package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartUpForm extends JFrame {

    public StartUpForm() {
        BufferedImage netflixLogo = null;
        try {
            netflixLogo = ImageIO.read(new File("path-to-file"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(netflixLogo));
        picLabel.add(picLabel);
    }
}
