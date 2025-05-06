package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class orders_detailsDAO {
    public void insertOrder_Details(int Order_details_id, int Product_id, int Product_quantity, double Price_per_item, int Orders){
        String sql = "INSERT INTO Orders_details (Order_details_id,Product_id,Product_quantity,Price_per_item,Orders) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Order_details_id);
            stmt.setInt(2, Product_id);
            stmt.setInt(3, Product_quantity);
            stmt.setDouble(4, Price_per_item);
            stmt.setInt(5, Orders);
            stmt.executeUpdate();
            System.out.println("Order added to orders details.");
        } catch (SQLException e) {
            System.out.println("Error adding order to orders details: " + e.getMessage());
        }
    }

}