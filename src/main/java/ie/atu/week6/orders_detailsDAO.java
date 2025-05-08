package ie.atu.week6;

import java.sql.*;

public class orders_detailsDAO {
    public void insertOrder_Details(int Order_details_id, int Product_id, int Product_quantity, double Price_per_item, int Orders) {
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

    public void showOrder_details() {
        String sql = "SELECT * FROM Orders_details_id";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("Order_details_id") + rs.getInt("Product_id") + rs.getInt("Orders"));
            }

        } catch (SQLException e) {
            System.out.println("Error displaying order details: " + e.getMessage());
        }
    }

    public void deleteOrder_details(int Orders_details_id) {
        String deleteOrderDetails = "DELETE FROM Orders_details WHERE Orders_details_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt1 = conn.prepareStatement(deleteOrderDetails)) {
            stmt1.setInt(1, Orders_details_id);
            int orderDetailsAffected = stmt1.executeUpdate();

            if (orderDetailsAffected > 0) {
                System.out.println("Order details removed from system.");
            } else {
                System.out.println("Order details not found in the system..");
            }

            String deleteOrdersSQL = "DELETE FROM Orders_details WHERE Orders_details_id = ?";
            try (PreparedStatement stmt2 = conn.prepareStatement(deleteOrdersSQL)) {
                stmt2.setInt(1, Orders_details_id);
                int orderDetailsDeleted = stmt2.executeUpdate();

                if (orderDetailsDeleted > 0) {
                    System.out.println("Order details number: " + Orders_details_id + " successfully deleted.");
                } else {
                    System.out.println("Order details  not found with number: " + Orders_details_id);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error deleting: " + e.getMessage());
        }
    }

}