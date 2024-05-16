package pl.wsb.hotel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    @Test
    void testSetName() {
        var hotel = new Hotel("some name");
        hotel.setName("changed name");

        assertEquals("changed name", hotel.getName());
    }

    @Test
    void testAddClient() {
        var hotel = new Hotel("");
        var clientId = hotel.addClient("John", "Kowalsky", LocalDate.now());
        var clientFullName = hotel.getClientFullName(clientId);

        assertNotNull(clientId);
        assertEquals(clientFullName, "John Kowalsky");
    }

    @Test
    void testGetNumberOfUnderageClients() {
        var hotel = new Hotel("");
        var adult1 = hotel.addClient("John", "Kowalsky", LocalDate.of(2000, 1, 1));
        var child1 = hotel.addClient("Staś", "Tarkowski", LocalDate.of(2015, 1, 1));
        var child2 = hotel.addClient("Nel", "Rawlison", LocalDate.of(2019, 1, 1));
        int numberOfUnderageClients = hotel.getNumberOfUnderageClients();

        assertEquals(2, numberOfUnderageClients);
    }

    @Test
    void testAddRoom() {
        var hotel = new Hotel("");
        var roomId = hotel.addRoom(10, 1, true, "no description");
        var roomArea = hotel.getRoomArea(roomId);

        assertEquals(10, roomArea);
    }

    @Test
    void testGetNumberOfRoomsWithKingSizeBed() {
        var hotel = new Hotel("");
        hotel.addRoom(10, 1, true, "room with king size bed");
        hotel.addRoom(15, 2, true, "another room with king size bed");
        hotel.addRoom(5, 1, false, "room without king size bed");
        var numberOfRoomsWithKingSizeBedAtFirstFloor = hotel.getNumberOfRoomsWithKingSizeBed(1);

        assertEquals(1, numberOfRoomsWithKingSizeBedAtFirstFloor);
    }

    @Test
    void testAddNewReservationSuccessful() throws ClientNotFoundException, RoomNotFoundException {
        var hotel = new Hotel("");
        var roomId = hotel.addRoom(10, 1, true, "room with king size bed");
        var clientId = hotel.addClient("Nel", "Rawlison", LocalDate.of(2019, 1, 1));
        var reservationId = hotel.addNewReservation(clientId, roomId, LocalDate.now());

        assertNotNull(reservationId);
    }

    @Test
    void testAddNewReservationShouldThrowNotFoundClient() throws ClientNotFoundException, RoomNotFoundException {
        var hotel = new Hotel("");
        var roomId = hotel.addRoom(10, 1, true, "room with king size bed");
        var clientId = "dummy";

        assertThrows(ClientNotFoundException.class, () -> hotel.addNewReservation(clientId, roomId, LocalDate.now()));
    }

    @Test
    void testAddNewReservationShouldThrowNotFoundRoom() throws ClientNotFoundException, RoomNotFoundException {
        var hotel = new Hotel("");
        var roomId = "dummy";
        var clientId = hotel.addClient("Nel", "Rawlison", LocalDate.of(2019, 1, 1));

        assertThrows(RoomNotFoundException.class, () -> hotel.addNewReservation(clientId, roomId, LocalDate.now()));
    }

    @Test
    void testAddNewReservationShouldThrowAlreadyReserved() throws RoomReservedException, ClientNotFoundException, RoomNotFoundException {
        var hotel = new Hotel("");
        var roomId = hotel.addRoom(10, 1, true, "room with king size bed");
        var clientId = hotel.addClient("Nel", "Rawlison", LocalDate.of(2019, 1, 1));
        hotel.addNewReservation(clientId, roomId, LocalDate.now());

        assertThrows(RoomReservedException.class, () -> hotel.addNewReservation(clientId, roomId, LocalDate.now()));
    }

    @Test
    void testConfirmReservationSuccess() throws ClientNotFoundException, RoomNotFoundException {
        var hotel = new Hotel("");
        var roomId = hotel.addRoom(10, 1, true, "room with king size bed");
        var clientId = hotel.addClient("Nel", "Rawlison", LocalDate.of(2019, 1, 1));
        var reservationId = hotel.addNewReservation(clientId, roomId, LocalDate.now());

        var numberOfUnconfirmedReservationsBefore = hotel.getNumberOfUnconfirmedReservation(LocalDate.now());
        hotel.confirmReservation(reservationId);
        var numberOfUnconfirmedReservationsAfter = hotel.getNumberOfUnconfirmedReservation(LocalDate.now());

        assertEquals(1, numberOfUnconfirmedReservationsBefore);
        assertEquals(0, numberOfUnconfirmedReservationsAfter);
    }

    @Test
    void testConfirmReservationShouldThrowReservationNotFound() {
        var hotel = new Hotel("");

        assertThrows(ReservationNotFoundException.class, () -> hotel.confirmReservation("dummy reservation"));
    }

    @Test
    void testRoomReserved() throws RoomNotFoundException, ClientNotFoundException {
        var hotel = new Hotel("");
        var roomId = hotel.addRoom(10, 1, true, "no description");
        var clientId = hotel.addClient("Nel", "Rawlison", LocalDate.of(2019, 1, 1));

        var isReservedForTodayBeforeReservation = hotel.isRoomReserved(roomId, LocalDate.now());
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        var isReservedForTodayAfterReservation = hotel.isRoomReserved(roomId, LocalDate.now());

        assertFalse(isReservedForTodayBeforeReservation);
        assertTrue(isReservedForTodayAfterReservation);
    }

    @Test
    void testGetNumberOfUnconfirmedReservation()
            throws RoomReservedException, ClientNotFoundException, RoomNotFoundException {
        var hotel = new Hotel("");
        var roomId = hotel.addRoom(10, 1, true, "room with king size bed");
        var clientId = hotel.addClient("Nel", "Rawlison", LocalDate.of(2019, 1, 1));
        var reservationId = hotel.addNewReservation(clientId, roomId, LocalDate.now());

        var numberOfUnconfirmedReservationsBeforeConfirmation = hotel
                .getNumberOfUnconfirmedReservation(LocalDate.now());
        hotel.confirmReservation(reservationId);
        var numberOfUnconfirmedReservationsAfterConfirmation = hotel.getNumberOfUnconfirmedReservation(LocalDate.now());

        assertEquals(1, numberOfUnconfirmedReservationsBeforeConfirmation);
        assertEquals(0, numberOfUnconfirmedReservationsAfterConfirmation);
    }

    @Test
    void testGetRoomIdsReservedByClient() throws RoomReservedException, ClientNotFoundException, RoomNotFoundException {
        var hotel = new Hotel("");
        var roomId1 = hotel.addRoom(10, 1, true, "room with king size bed");
        var roomId2 = hotel.addRoom(15, 2, true, "another room with king size bed");
        var clientId = hotel.addClient("Nel", "Rawlison", LocalDate.of(2019, 1, 1));
        var reservationId1 = hotel.addNewReservation(clientId, roomId1, LocalDate.now());
        var reservationId2 = hotel.addNewReservation(clientId, roomId2, LocalDate.now());

        var roomIdsReservedByClient = hotel.getRoomIdsReservedByClient(clientId);

        assertEquals(2, roomIdsReservedByClient.size());
    }

}
