package OnlineLibrarymanagSystem;


import javax.swing.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {
    JButton manageBooks, manageUsers, issueBook, reports, logout;

    AdminDashboard() {
        setTitle("Admin Dashboard");

        manageBooks = new JButton("Manage Books");
        manageBooks.setBounds(50, 50, 150, 30);
        manageBooks.addActionListener(this);
        add(manageBooks);

        manageUsers = new JButton("Manage Users");
        manageUsers.setBounds(50, 100, 150, 30);
        manageUsers.addActionListener(this);
        add(manageUsers);

        issueBook = new JButton("Issue / Return");
        issueBook.setBounds(50, 150, 150, 30);
        issueBook.addActionListener(this);
        add(issueBook);

        reports = new JButton("Reports");
        reports.setBounds(50, 200, 150, 30);
        reports.addActionListener(this);
        add(reports);

        logout = new JButton("Logout");
        logout.setBounds(50, 250, 150, 30);
        logout.addActionListener(this);
        add(logout);

        setLayout(null);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logout) {
            new LoginPage();
            dispose();
        }
        // TODO: Add code to open respective modules
    }
}
