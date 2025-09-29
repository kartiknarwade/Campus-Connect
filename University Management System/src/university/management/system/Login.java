package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton, registerButton;

    public Login() {
        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // center screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        usernameField = new JTextField(20); // wider field
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        mainPanel.add(usernameField, gbc);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 18));
        passwordField = new JPasswordField(20);
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(passLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        mainPanel.add(passwordField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        registerButton = new JButton("Register");
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        registerButton.addActionListener(this);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        cancelButton.setFont(new Font("Arial", Font.BOLD, 20));
        registerButton.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            loginUser();
        } else if (ae.getSource() == cancelButton) {
            System.exit(0);
        } else if (ae.getSource() == registerButton) {
            new RegisterForm().setVisible(true); // Open register form
            this.dispose();
        }
    }

    private void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                setVisible(false);
                new Project().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
