package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ordersDAO {
    public void name(){
        String sql = "";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


        } catch (SQLException e) {
            System.out.println("Error adding to order: " + e.getMessage());
        }
    }

}