package ie.atu.week6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class productDAO {
    public void showProducts() {
        String sql = "SELECT * FROM products";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("Product_name") + " - €" + rs.getDouble("Product_price"));
            }

        } catch (SQLException e) {
            System.out.println("Error getting product: " + e.getMessage());
        }
    }
}
