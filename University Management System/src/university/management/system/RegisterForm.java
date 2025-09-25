package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterForm extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, backButton;

    public RegisterForm() {
        setTitle("Register New User");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fonts
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        Font fieldFont = new Font("Arial", Font.BOLD, 20);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        // Username
        JLabel userLabel = new JLabel("New Username:");
        userLabel.setFont(labelFont);
        usernameField = new JTextField(20);
        usernameField.setFont(fieldFont);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(usernameField, gbc);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(labelFont);
        passwordField = new JPasswordField(20);
        passwordField.setFont(fieldFont);
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(passLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(passwordField, gbc);

        // Confirm Password
        JLabel confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setFont(labelFont);
        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(fieldFont);
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(confirmLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(confirmPasswordField, gbc);

        // Buttons
        JPanel btnPanel = new JPanel();
        registerButton = new JButton("Register");
        registerButton.setFont(buttonFont);
        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        registerButton.addActionListener(this);
        backButton.addActionListener(this);
        btnPanel.add(registerButton);
        btnPanel.add(backButton);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnPanel, gbc);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == registerButton) {
            registerUser();
        } else if (ae.getSource() == backButton) {
            new Login().setVisible(true);
            this.dispose();
        }
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }

        try {
            conn c = new conn();
            String insertQuery = "INSERT INTO login(username, password) VALUES (?, ?)";
            PreparedStatement pst = c.c.prepareStatement(insertQuery);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "User Registered Successfully!");
            new Login().setVisible(true);
            this.dispose();

            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisterForm().setVisible(true));
    }
}
