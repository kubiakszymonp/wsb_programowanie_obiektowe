package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

public class TimeServiceTest {
    @Test
    void testGetTimeServicePrice() {
        var timeService = new TimeService();
        var priceInPLN = timeService.getServicePrice("PLN");
        var priceInUSD = timeService.getServicePrice("USD");
        assertNotEquals(priceInPLN, priceInUSD);
    }

    @Test
    void testCanClientUseIt() {
        var timeService = new TimeService();
        var client = new Client("id", "John", "Kowalsky", LocalDate.of(2023, 1, 1));

        assertEquals(true, timeService.canClientUseIt(client));
    }
}
