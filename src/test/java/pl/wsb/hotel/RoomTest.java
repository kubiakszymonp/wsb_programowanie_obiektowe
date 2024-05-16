package pl.wsb.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class RoomTest {
    @Test
    void testDefaultValuesConstructor() {

        var room = new Room("1", 10, 1, true, "no description");
        assertEquals("1", room.getId());
        assertEquals(10, room.getArea());
        assertEquals(1, room.getFloor());
        assertEquals(true, room.getHasKingSizeBed());
        assertEquals("no description", room.getDescription());
        assertFalse(room.getHasBalcony());
        assertFalse(room.getHasBathroom());
        assertEquals(0, room.getPrice());
    }
}
