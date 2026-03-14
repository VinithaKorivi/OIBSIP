package Project1;


import java.util.Scanner;

public class Login {

    public static boolean login() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        if(username.equalsIgnoreCase("admin") && password.equals("1234")) {
            System.out.println("Login Successful");
            return true;
        } 
        else {
            System.out.println("Invalid Login");
            return false;
        }
    }
}
