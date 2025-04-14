package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.Scanner;

public class Login {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    //  constructor for  testing
    public Login(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }



    /*public static void userReg(){
        // Registration logic here
    }*/

    /*public void getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        lastName = scanner.nextLine();

        System.out.println("Enter your email: ");
        email = scanner.nextLine();

        System.out.println("Enter your username: ");
        username = scanner.nextLine();

        System.out.println("Enter your password: ");
        password = scanner.nextLine();

        scanner.close();
    } */

    // Getters for testing
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}