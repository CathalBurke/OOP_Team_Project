

import ie.atu.week6.DatabaseConnection;
//import ie.atu.week6.Login;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

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
}

// login test


/*public class LoginTest {
    @Test
    void testLoginFieldsStoreCorrectly() {
        //Login login = new Login("John", "Doe", "john@doe.com", "johndoe", "pass123");
        assertNotNull(login);
    }
} */