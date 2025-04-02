
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;


public class LoginTest {
    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testGetInput() {
        // Prepare simulated input
        String input = "John\nDoe\njohn.doe@example.com\njohndoe\npassword123";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Create scanner and call getInput method
        Scanner scanner = new Scanner(System.in);
        login.getInput(scanner);

        // Check if the values are set correctly
        assertEquals("John", login.getFirstName());
        assertEquals("Doe", login.getLastName());
        assertEquals("john.doe@example.com", login.getEmail());
        assertEquals("johndoe", login.getUsername());
        assertEquals("password123", login.getPassword());
}
