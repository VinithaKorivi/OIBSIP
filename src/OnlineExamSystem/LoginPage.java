package OnlineExamSystem;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class LoginPage extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    
    
    static HashMap<String, String> users = new HashMap<>();

    public LoginPage() {
       
        users.put("vinitha", "12345");

        setTitle("Login Page");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 150, 30);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if(users.containsKey(user) && users.get(user).equals(pass)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new Dashboard(user); 
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}