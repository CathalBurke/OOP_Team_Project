package ie.atu.week6;

import java.sql.*;

public class loginDAO {
    public void insertLogIn(int UserID, String First_name, String Last_name, String Email, String Username, String Password){
        String sql = "INSERT INTO login (UserID, First_name, Last_name, Email, Username, Password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, UserID);
            stmt.setString(2, First_name);
            stmt.setString(3, Last_name);
            stmt.setString(4, Email);
            stmt.setString(5, Username);
            stmt.setString(6, Password);
            stmt.executeUpdate();
            System.out.println("User added to login details.");
        } catch (SQLException e) {
            System.out.println("Error adding user to login details: " + e.getMessage());
        }
    }
    public void showLogin(){
        String sql = "SELECT * FROM login";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("Email") + rs.getString("Username") + rs.getString("Password"));
            }

        } catch (SQLException e) {
            System.out.println("Error displaying login details: " + e.getMessage());
        }
    }


}
