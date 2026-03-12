package OnlineExamSystem;

import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JButton updateProfileButton, startExamButton, logoutButton;
    String loggedInUser;

    public Dashboard(String username) {
        loggedInUser = username;

        setTitle("Dashboard");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startExamButton = new JButton("Start Exam");
        startExamButton.setBounds(100, 50, 200, 30);
        startExamButton.addActionListener(this);
        add(startExamButton);

        updateProfileButton = new JButton("Update Profile");
        updateProfileButton.setBounds(100, 100, 200, 30);
        updateProfileButton.addActionListener(this);
        add(updateProfileButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(100, 150, 200, 30);
        logoutButton.addActionListener(this);
        add(logoutButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startExamButton) {
            new ExamPage(loggedInUser);
            dispose();
        } else if(e.getSource() == updateProfileButton) {
            new UpdateProfile(loggedInUser);
            dispose();
        } else if(e.getSource() == logoutButton) {
            JOptionPane.showMessageDialog(this, "Logged Out Successfully!");
            new LoginPage();
            dispose();
        }
    }
}