package OnlineExamSystem;

import javax.swing.*;
import java.awt.event.*;

public class UpdateProfile extends JFrame implements ActionListener {
    JTextField nameField;
    JPasswordField passField;
    JButton updateButton;
    String loggedInUser;

    public UpdateProfile(String username) {
        loggedInUser = username;

        setTitle("Update Profile");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setBounds(50, 50, 100, 30);
        add(nameLabel);

        nameField = new JTextField(loggedInUser);
        nameField.setBounds(150, 50, 150, 30);
        add(nameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 30);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 30);
        add(passField);

        updateButton = new JButton("Update");
        updateButton.setBounds(150, 150, 100, 30);
        updateButton.addActionListener(this);
        add(updateButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newUser = nameField.getText();
        String newPass = new String(passField.getPassword());

        if(!newUser.isEmpty() && !newPass.isEmpty()) {
            // update in-memory user
            LoginPage.users.remove(loggedInUser);
            LoginPage.users.put(newUser, newPass);

            JOptionPane.showMessageDialog(this, "Profile Updated Successfully!");
            new Dashboard(newUser);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Fields cannot be empty!");
        }
    }
}