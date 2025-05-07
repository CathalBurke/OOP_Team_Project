package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
public boolean validlogin(String username, String Password){
        String sql = "SELECT * FROM login WHERE username = ? AND Password = ?";
        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, username);
            stmt.setString(2, Password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
        catch (SQLException e){
            System.out.println("error login"+ e.getMessage());
            return false;
        }
}
}