package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class orders_detailsDAO {
    public void name(){
        String sql = "INSERT INTO orders_details (Order_details_id, Product_id, Product_quantity, Price_per_item, Orders) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


        } catch (SQLException e) {
            System.out.println("Error adding to orders details: " + e.getMessage());
        }
    }

}