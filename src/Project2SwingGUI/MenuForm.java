package Project2SwingGUI;


import javax.swing.*;
import java.awt.event.*;

public class MenuForm {

    public MenuForm(){

        JFrame frame = new JFrame("Reservation System");

        JButton reserveButton = new JButton("Reservation");
        reserveButton.setBounds(120,50,150,40);

        JButton cancelButton = new JButton("Cancellation");
        cancelButton.setBounds(120,120,150,40);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(120,190,150,40);

        frame.add(reserveButton);
        frame.add(cancelButton);
        frame.add(exitButton);

        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);

        reserveButton.addActionListener(e -> new ReservationForm());

        cancelButton.addActionListener(e -> new CancellationForm());

        exitButton.addActionListener(e -> System.exit(0));
    }
}