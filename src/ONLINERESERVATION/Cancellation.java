package Project1;

import java.sql.*;
import java.util.Scanner;

public class Cancellation {

    public void cancelTicket() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/reservation_system",
                    "root",
                    "Tiger@1");

            System.out.println("Enter PNR Number:");
            int pnr = sc.nextInt();

            String query = "select * from reservation where pnr=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, pnr);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("PNR Found");

                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Train: " + rs.getString("train_name"));

                System.out.println("Confirm Cancellation? (yes/no)");

                sc.nextLine();
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {

                    String deleteQuery = "delete from reservation where pnr=?";

                    PreparedStatement ps2 = con.prepareStatement(deleteQuery);
                    ps2.setInt(1, pnr);

                    ps2.executeUpdate();

                    System.out.println("Ticket Cancelled");

                }

            } else {
                System.out.println("PNR Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}