package Project1;

import java.sql.*;
import java.util.Scanner;

public class Reservation {

    public void bookTicket() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/reservation_system",
                    "root",
                    "Tiger@1");

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Train Number:");
            int trainNo = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Train Name:");
            String trainName = sc.nextLine();

            System.out.println("Enter Class Type:");
            String classType = sc.nextLine();

            System.out.println("Enter Journey Date (yyyy-mm-dd):");
            String date = sc.nextLine();

            System.out.println("From Place:");
            String from = sc.nextLine();

            System.out.println("To Destination:");
            String to = sc.nextLine();

            String query = "insert into reservation(name,train_no,train_name,class_type,journey_date,from_place,to_place) values(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, trainNo);
            ps.setString(3, trainName);
            ps.setString(4, classType);
            ps.setString(5, date);
            ps.setString(6, from);
            ps.setString(7, to);

            ps.executeUpdate();

            System.out.println("Reservation Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}