package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {

    private String First_name = "";
    private String Last_name = "";
    private String Email = "";
    private String Username = "";
    private String Password = "";


    public static void userReg(){

    }

    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        First_name = scanner.nextLine();

        System.out.println("Enter your last name: ");
        Last_name = scanner.nextLine();

        System.out.println("Enter your email: ");
        Email = scanner.nextLine();

        System.out.println("Enter your username: ");
        Username = scanner.nextLine();

        System.out.println("Enter your password: ");
        Password = scanner.nextLine();

        scanner.close(); 
    }
}
