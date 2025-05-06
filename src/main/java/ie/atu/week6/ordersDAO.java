package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ordersDAO {
    public void insertOrder(int Orders, int UserID, double Total_Amount, String Order_Date){
        String sql = "INSERT INTO orders (Orders,UserID,Total_Amount,Order_Date) VALUES (?, ?, ?, ?, ?, ?) ";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Orders);
            stmt.setInt(2, UserID);
            stmt.setDouble(3, Total_Amount);
            stmt.setString(4, Order_Date);
            stmt.executeUpdate();
            System.out.println("Item added to order.");
        } catch (SQLException e) {
            System.out.println("Error adding to order: " + e.getMessage());
        }
    }

}