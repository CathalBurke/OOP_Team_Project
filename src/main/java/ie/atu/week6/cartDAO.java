package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cartDAO {
    public void addtoCart(int userId, int productId, int quantity){
        String sql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
            System.out.println("Item added to cart.");
        } catch (SQLException e) {
            System.out.println("Error adding to cart: " + e.getMessage());
        }
    }

}
