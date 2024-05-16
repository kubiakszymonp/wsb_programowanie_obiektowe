package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClientTest {

    @Test
    void testGetFullName() {
        var client = new Client("id", "John", "Kowalsky", LocalDate.now());
        var fullName = client.getFullName();

        assertEquals("John Kowalsky", fullName);
    }

    @Test
    void testGetAge() {
        var client = new Client("id", "John", "Kowalsky", LocalDate.of(2000, 1, 1));
        var age = client.getAge();

        assertEquals(24, age);
    }

    @Test
    void testConstructorDefaultValues() {
        var client = new Client("id", "John", "Kowalsky", LocalDate.of(2000, 1, 1));
        assertEquals("id", client.getId());
        assertEquals("John", client.getFirstName());
        assertEquals("Kowalsky", client.getLastName());
        assertEquals(LocalDate.of(2000, 1, 1), client.getBirthDate());
        assertNull(client.getPhoneNumber());
        assertNull(client.getEmail());
        assertNull(client.getPhoneNumber());
    }

    @Test
    void testPremiumClient() {
        var client = new PremiumClient("id", "John", "Kowalsky", LocalDate.of(2000, 1, 1), "a@gmail.com", "123456789",
                "Warszawa", PremiumAccountType.PREMIUM);
        var fullName = client.getFullName();

        assertEquals("[premium] John Kowalsky", fullName);
    }

    @Test
    void testClientToString(){
        var client = new Client("id", "John", "Kowalsky", LocalDate.of(2000, 1, 1));
        var clientString = client.toString();

        assertNotNull(clientString);
    }

}
