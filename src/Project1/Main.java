package Project1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (Login.login()) {

            Scanner sc = new Scanner(System.in);

            Reservation r = new Reservation();
            Cancellation c = new Cancellation();

            while (true) {

                System.out.println("1. Reservation");
                System.out.println("2. Cancellation");
                System.out.println("3. Exit");

                System.out.println("Choose Option:");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        r.bookTicket();
                        break;

                    case 2:
                        c.cancelTicket();
                        break;

                    case 3:
                        System.exit(0);

                    default:
                        System.out.println("Invalid Option");
                }
            }

        }

    }

}