package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame {
    private JLabel background;

    public Splash() {
        setTitle("Solapur University");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load your splash image
        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/first.jpg"));
        Image img = imgIcon.getImage();

        background = new JLabel();
        background.setHorizontalAlignment(JLabel.CENTER);
        background.setVerticalAlignment(JLabel.CENTER);
        add(background, BorderLayout.CENTER);

        // Show image scaled initially
        setScaledImage(img);

        // Resize dynamically when window is resized
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                setScaledImage(img);
            }
        });

        // Timer to open Login page after 3 seconds
        Timer timer = new Timer(3000, e -> {
            setVisible(false);
            try {
                new Login().setVisible(true); // Opens your login page
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            dispose();
        });
        timer.setRepeats(false); // Run only once
        timer.start();

        setVisible(true);
    }

    private void setScaledImage(Image img) {
        int w = getWidth();
        int h = getHeight();
        if (w > 0 && h > 0) {
            Image scaled = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            background.setIcon(new ImageIcon(scaled));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Splash());
    }
}
