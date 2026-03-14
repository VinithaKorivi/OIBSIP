package Project2SwingGUI;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CancellationForm {

    public CancellationForm() {

        JFrame frame = new JFrame("Cancel Ticket");

        JLabel pnrLabel = new JLabel("PNR Number");
        pnrLabel.setBounds(50,50,100,30);

        JTextField pnrField = new JTextField();
        pnrField.setBounds(150,50,150,30);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(50,100,100,30);

        JButton cancelButton = new JButton("OK");
        cancelButton.setBounds(200,100,100,30);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(50,150,300,150);

        frame.add(pnrLabel);
        frame.add(pnrField);
        frame.add(searchButton);
        frame.add(cancelButton);
        frame.add(resultArea);

        frame.setSize(400,350);
        frame.setLayout(null);
        frame.setVisible(true);

        // SEARCH BUTTON
        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    Connection con = DBConnection.getConnection();

                    String query = "select * from reservation where pnr=?";

                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setInt(1,Integer.parseInt(pnrField.getText()));

                    ResultSet rs = ps.executeQuery();

                    if(rs.next()) {

                        resultArea.setText(
                        "Name: " + rs.getString("name") + "\n" +
                        "Train No: " + rs.getInt("train_no") + "\n" +
                        "Train Name: " + rs.getString("train_name") + "\n" +
                        "Class: " + rs.getString("class_type") + "\n" +
                        "Date: " + rs.getString("journey_date") + "\n" +
                        "From: " + rs.getString("from_place") + "\n" +
                        "To: " + rs.getString("to_place")
                        );

                    } else {

                        resultArea.setText("PNR Not Found");

                    }

                } catch(Exception ex) {
                    ex.printStackTrace();
                }

            }

        });

        // CANCEL BUTTON
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    Connection con = DBConnection.getConnection();

                    String query = "delete from reservation where pnr=?";

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setInt(1,Integer.parseInt(pnrField.getText()));

                    int rows = ps.executeUpdate();

                    if(rows>0){

                        JOptionPane.showMessageDialog(frame,"Ticket Cancelled");

                        resultArea.setText("");

                    } else {

                        JOptionPane.showMessageDialog(frame,"PNR Not Found");

                    }

                } catch(Exception ex) {
                    ex.printStackTrace();
                }

            }

        });

    }

}