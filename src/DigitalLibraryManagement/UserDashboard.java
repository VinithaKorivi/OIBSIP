package OnlineLibrarymanagSystem;


import javax.swing.*;
import java.awt.event.*;

public class UserDashboard extends JFrame implements ActionListener {
    int userId;
    JButton browseBooks, issueBook, returnBook, query, logout;

    UserDashboard(int userId) {
        this.userId = userId;
        setTitle("User Dashboard");

        browseBooks = new JButton("Browse Books");
        browseBooks.setBounds(50, 50, 150, 30);
        browseBooks.addActionListener(this);
        add(browseBooks);

        issueBook = new JButton("Issue Book");
        issueBook.setBounds(50, 100, 150, 30);
        issueBook.addActionListener(this);
        add(issueBook);

        returnBook = new JButton("Return Book");
        returnBook.setBounds(50, 150, 150, 30);
        returnBook.addActionListener(this);
        add(returnBook);

        query = new JButton("Send Query");
        query.setBounds(50, 200, 150, 30);
        query.addActionListener(this);
        add(query);

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
        // TODO: Implement browse, issue, return, query functionality
    }
}