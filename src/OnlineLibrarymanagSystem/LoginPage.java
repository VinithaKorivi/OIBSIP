package OnlineLibrarymanagSystem;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;

    LoginPage() {
        setTitle("Library Login");

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(50, 50, 100, 30);
        add(l1);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 150, 30);
        add(usernameField);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);
        add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 150, 100, 30);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setLayout(null);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String role = rs.getString("role");
                if(role.equalsIgnoreCase("admin")) {
                    new AdminDashboard();
                } else {
                    new UserDashboard(rs.getInt("user_id"));
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
