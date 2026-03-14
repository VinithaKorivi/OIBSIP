package Project2SwingGUI;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ReservationForm {

    public ReservationForm() {

        JFrame frame = new JFrame("Reservation Form");

        JTextField name = new JTextField();
        name.setBounds(150,50,150,30);

        JTextField trainNo = new JTextField();
        trainNo.setBounds(150,90,150,30);

        JTextField trainName = new JTextField();
        trainName.setBounds(150,130,150,30);
        
        JTextField classType = new JTextField();
        classType.setBounds(150,170,150,30);

        JTextField date = new JTextField();
        date.setBounds(150,210,150,30);

        JTextField from = new JTextField();
        from.setBounds(150,250,150,30);

        JTextField to = new JTextField();
        to.setBounds(150,290,150,30);
        

        frame.add(new JLabel("Name")).setBounds(50,50,100,30);
        frame.add(name);

        frame.add(new JLabel("Train No")).setBounds(50,90,100,30);
        frame.add(trainNo);

        frame.add(new JLabel("Train Name")).setBounds(50,130,100,30);
        frame.add(trainName);
        
        frame.add(new JLabel("Class Type")).setBounds(50,170,100,30);
        frame.add(classType);

        frame.add(new JLabel("Journey Date")).setBounds(50,210,100,30);
        frame.add(date);

        frame.add(new JLabel("From")).setBounds(50,250,100,30);
        frame.add(from);

        frame.add(new JLabel("To")).setBounds(50,290,100,30);
        frame.add(to);

        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(140,340,120,35);

        frame.add(insertButton);
        
        frame.setSize(400,450);
        frame.setLayout(null);
        frame.setVisible(true);

        insertButton.addActionListener(e -> {

            try {

                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/reservation_system",
                    "root",
                    "Tiger@1"
                );

                String query = "insert into reservation(name,train_no,train_name,class_type,journey_date,from_place,to_place) values(?,?,?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, name.getText());
                ps.setInt(2, Integer.parseInt(trainNo.getText()));
                ps.setString(3, trainName.getText());
                ps.setString(4, classType.getText());
                ps.setString(5, date.getText());
                ps.setString(6, from.getText());
                ps.setString(7, to.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame,"Reservation Successful");

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        });

    }

}