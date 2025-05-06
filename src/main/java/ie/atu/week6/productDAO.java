package ie.atu.week6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void insertProducts(Product product){
        String sql = "INSERT INTO products (Product_name, Product_description, Product_price, Category_id) VALUES(?, ?, ?, ?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getProductDescription());
            stmt.setDouble(3, product.getProductPrice());
            stmt.setInt(4, product.getCategoryID());

            stmt.executeUpdate();
            System.out.println("Product added");
        }
        catch(SQLException e){
            System.out.println("Error inserting product" + e.getMessage());
        }
    }

    public void deleteProduct(int productID) {
        // First, delete from dependent tables (cart)
        String deleteFromCart = "DELETE FROM cart WHERE product_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt1 = conn.prepareStatement(deleteFromCart)) {

            // Delete from cart
            stmt1.setInt(1, productID);
            int rowsAffected = stmt1.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product removed from cart.");
            } else {
                System.out.println("Product not found in cart.");
            }

            // Now delete from products
            String deleteProductSQL = "DELETE FROM products WHERE product_id = ?";
            try (PreparedStatement stmt2 = conn.prepareStatement(deleteProductSQL)) {
                stmt2.setInt(1, productID);
                int rowsDeleted = stmt2.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Product with ID: " + productID + " successfully deleted.");
                } else {
                    System.out.println("Product not found with ID: " + productID);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error with deletion: " + e.getMessage());
        }
    }
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getDouble("product_price"),
                        rs.getInt("category_id")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving products: " + e.getMessage());
        }

        return products;
    }
}
