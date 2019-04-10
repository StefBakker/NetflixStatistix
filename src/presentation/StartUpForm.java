package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUpForm extends JFrame {

    private JPanel mainPanel;
    private JPanel loginPanel;
    private JTextField textField1;
    private JButton loginButton;
    private JButton registerButton;

    public StartUpForm() {
        add(mainPanel);

        setBackground(Color.black);
        setSize(700,300);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/Netflix.png")));
        centerFrame();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterForm registerForm = new RegisterForm();
                registerForm.setVisible(true);
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
