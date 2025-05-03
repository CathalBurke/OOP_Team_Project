package ie.atu.week6;

import java.sql.*;

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

    public void deleteProduct(int productID){
        String sql = "DELETE FROM products WHERE product_id = ?)";
        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, productID);

            int rows = stmt.executeUpdate();
            if(rows < 0){
                System.out.println("Product ID: " + productID + "successfully deleted.");
            }
            else{
                System.out.println("Product not found:" + productID);
            }
        }
        catch(SQLException e){
            System.out.println("Error with deletion" + e.getMessage());
        }
    }

}
