package ie.atu.week6;

import java.sql.*;

public class ordersDAO {
    public void insertOrder(int Orders, int UserID, double Total_Amount, String Order_Date) {
        String sql = "INSERT INTO orders (Orders,UserID,Total_Amount,Order_Date) VALUES (?, ?, ?, ?) ";
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

    public void showOrder() {
        String sql = "SELECT * FROM orders";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("Orders") + rs.getString("UserID") + rs.getString("Total_Amount") + rs.getString("Order_Date"));
            }

        } catch (SQLException e) {
            System.out.println("Error displaying order details: " + e.getMessage());
        }
    }

    public void deleteOrder(int Orders){
 String deleteOrders = "DELETE FROM orders WHERE Orders = ?";

 try(Connection conn = DatabaseConnection.getConnection();
     PreparedStatement stmt1 = conn.prepareStatement(deleteOrders)){
     stmt1.setInt(1, Orders);
     int orderAffected = stmt1.executeUpdate();

     if (orderAffected > 0) {
         System.out.println("Order removed from system.");
     } else {
         System.out.println("Order not found in the system..");
     }

     String deleteOrdersSQL = "DELETE FROM orders WHERE Orders = ?";
     try (PreparedStatement stmt2 = conn.prepareStatement(deleteOrdersSQL)) {
         stmt2.setInt(1, Orders);
         int orderDeleted = stmt2.executeUpdate();

         if (orderDeleted > 0) {
             System.out.println("Order number: " + Orders + " successfully deleted.");
         } else {
             System.out.println("Order not found with number: " + Orders);
         }
     }

 } catch (SQLException e) {
     System.out.println("Error deleting: " + e.getMessage());
 }
 }

    }

