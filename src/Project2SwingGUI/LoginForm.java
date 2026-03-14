package Project2SwingGUI;


import javax.swing.*;
import java.awt.event.*;

public class LoginForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50,50,100,30);

        JTextField userField = new JTextField();
        userField.setBounds(150,50,150,30);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50,100,100,30);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150,100,150,30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120,150,100,30);

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);

        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String user = userField.getText();
                String pass = passField.getText();

                if(user.equals("admin") && pass.equals("1234")){

                    JOptionPane.showMessageDialog(frame,"Login Successful");

                    new MenuForm();  
                    frame.dispose(); 
                    frame.dispose();

                } else {

                    JOptionPane.showMessageDialog(frame,"Invalid Login");

                }

            }
        });

    }
}