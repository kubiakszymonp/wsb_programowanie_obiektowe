package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

public class LuggageServiceTest {

    @Test
    void testGetServicePrice() {
        var luggageService = new LuggageService();
        var priceInPLN = luggageService.getServicePrice("PLN");
        var priceInUSD = luggageService.getServicePrice("USD");
        assertNotEquals(priceInPLN, priceInUSD);
    }

    @Test
    void testSetServiceName() {
        var luggageService = new LuggageService();
        luggageService.setName("Luggage");

        assertEquals("Luggage", luggageService.getName());
    }

    @Test
    void testCanClientUseIt() {
        var luggageService = new LuggageService();
        var client = new Client("id", "John", "Kowalsky", LocalDate.of(2023, 1, 1));

        assertEquals(false, luggageService.canClientUseIt(client));
    }
}
