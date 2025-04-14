package ie.atu.week6;

import ie.atu.week6.DatabaseConnection;
import ie.atu.week6.Login;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    // --- Connection Tests ---
    @Test
    void testDatabaseConnectionNotNull() {
        Connection conn = DatabaseConnection.getConnection();
        assertNotNull(conn, "Connection should not be null");
    }

    @Test
    void testDatabaseConnectionIsValid() throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
            assertTrue(conn.isValid(2), "Connection should be valid");
        }
    }

    // --- Data Lookup Tests ---
    @Test
    void testUserExistsInLoginTable() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM login WHERE email = ?");
            stmt.setString(1, "johnalons@gmail.com");
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Expected user with email 'johnalons@gmail.com' to exist");
        } catch (Exception e) {
            fail("Error querying login table: " + e.getMessage());
        }
    }

    @Test
    void testProductSearchByName() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Use the correct column name "Product_name"
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE Product_name = ?");
            stmt.setString(1, "Black T-shirt");
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Product 'Black T-shirt' should exist in products table");
        } catch (Exception e) {
            fail("Error querying products table: " + e.getMessage());
        }
    }

    @Test
    void testCategoryLookup() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Use the correct column name "Category_name"
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM category WHERE Category_name = ?");
            stmt.setString(1, "Electronics");
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Category 'Electronics' should exist");
        } catch (Exception e) {
            fail("Error querying category table: " + e.getMessage());
        }
    }

    @Test
    void testCartHasEntries() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cart");
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Cart should contain at least one entry");
        } catch (Exception e) {
            fail("Error querying cart table: " + e.getMessage());
        }
    }

    @Test
    void testOrderDataExists() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders");
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Orders should exist in orders table");
        } catch (Exception e) {
            fail("Error querying orders table: " + e.getMessage());
        }
    }

    @Test
    void testOrderDetailsDataExists() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM order_details");
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Order details should exist in order_details table");
        } catch (Exception e) {
            fail("Error querying order_details table: " + e.getMessage());
        }
    }

    // --- Login Tests ---
    @Test
    void testLoginConstructorStoresFields() {
        Login login = new Login("John", "Doe", "john@doe.com", "johndoe", "pass123");
        assertNotNull(login, "Login object should not be null");
        assertEquals("John", login.getFirstName(), "First name should be stored correctly");
        assertEquals("Doe", login.getLastName(), "Last name should be stored correctly");
        assertEquals("john@doe.com", login.getEmail(), "Email should be stored correctly");
        assertEquals("johndoe", login.getUsername(), "Username should be stored correctly");
        assertEquals("pass123", login.getPassword(), "Password should be stored correctly");
    }
}