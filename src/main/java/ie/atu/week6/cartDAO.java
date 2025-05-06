package ie.atu.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class cartDAO {
    public void addtoCart(int userId, int productId, int quantity){
        String checkCart = "SELECT Product_quantity  FROM cart WHERE userid = ? AND product_id = ?";
        String sql = "INSERT INTO cart (userid, product_id, Product_quantity) VALUES (?, ?, ?)";
        String update = "UPDATE cart SET Product_quantity = ? WHERE userid = ? AND product_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkCart)) {

            checkStmt.setInt(1, userId);
            checkStmt.setInt(2, productId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                int currentQuantity = rs.getInt("Product_quantity");
                try (PreparedStatement updateStmt = conn.prepareStatement(update)) {
                    updateStmt.setInt(1, currentQuantity + quantity);
                    updateStmt.setInt(2, userId);
                    updateStmt.setInt(3, productId);
                    updateStmt.executeUpdate();
                    System.out.println("quantity updated");
                }
            } else {
                try (PreparedStatement insertStmt = conn.prepareStatement(sql)) {
                    insertStmt.setInt(1, userId);
                    insertStmt.setInt(2, productId);
                    insertStmt.setInt(3, quantity);
                    insertStmt.executeUpdate();
                    System.out.println("Item added to cart.");
                }

            }
        } catch (SQLException e) {
            System.out.println("Error adding to cart: " + e.getMessage());
        }
    }
    public List<CartItem> getCartByUserId(int userId) {
        List<CartItem> cartItems = new ArrayList<>();

        // Update the column name here to match the actual column in your database
        String sql = "SELECT p.product_id, p.product_name, p.product_description, p.product_price, c.Product_quantity " +
                "FROM cart c " +
                "JOIN products p ON c.product_id = p.product_id " +
                "WHERE c.userID = ?";  // Assuming 'userID' is the correct column name

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                String productDescription = rs.getString("product_description");
                double price = rs.getDouble("product_price");
                int quantity = rs.getInt("Product_quantity");

                double totalPrice = price * quantity;

                // Create a CartItem object and add it to the list
                CartItem item = new CartItem(productId, productName, productDescription, price, quantity, totalPrice);
                cartItems.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving cart items: " + e.getMessage());
        }

        return cartItems;
    }

}
