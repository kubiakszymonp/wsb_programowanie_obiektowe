package pl.wsb.hotel;

import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;
import pl.wsb.hotel.interfaces.HotelCapability;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Hotel implements HotelCapability {
    private String name;
    private List<SpecialService> specialServices;
    private List<Client> clients;
    private List<RoomReservation> reservations;
    private List<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.specialServices = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        Client client = new Client(this.generateUUID(), firstName, lastName, birthDate);
        clients.add(client);

        return client.getId();
    }

    @Override
    public String getClientFullName(String clientId) {
        Client client = null;
        for (Client c : clients) {
            if (c.getId().equals(clientId)) {
                client = c;
            }
        }

        if (client == null) {
            return "";
        } else {
            return client.getFullName();
        }
    }

    @Override
    public int getNumberOfUnderageClients() {
        int numberOfUnderageClients = 0;
        int ageThreshold = 18;
        for (Client c : clients) {
            if (c.getAge() < ageThreshold) {
                numberOfUnderageClients++;
            }
        }

        return numberOfUnderageClients;
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        Room room = new Room(this.generateUUID(), area, floor, hasKingSizeBed, description);
        rooms.add(room);
        return room.getId();
    }

    @Override
    public double getRoomArea(String roomId) {
        for (Room room : rooms) {
            if (room.getId().equals(roomId)) {
                return room.getArea();
            }
        }
        return 0;
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {
        int numberOfKingSizeBed = 0;
        for (Room room : rooms) {
            if (room.getHasKingSizeBed() && floor == room.getFloor()) {
                numberOfKingSizeBed++;
            }
        }
        return numberOfKingSizeBed;
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        Client client = null;
        Room room = null;

        // find client
        for (Client c : clients) {
            if (c.getId().equals(clientId)) {
                client = c;
            }
        }
        if (client == null) {
            throw new ClientNotFoundException("Client not found");
        }

        // find room
        for (Room r : rooms) {
            if (r.getId().equals(roomId)) {
                room = r;
            }
        }

        if (room == null) {
            throw new RoomNotFoundException("Room not found");
        }

        if(this.isRoomReserved(roomId, date)){
            throw new RoomReservedException(roomId, date);
        }


        RoomReservation reservation = new RoomReservation(this.generateUUID(), client, room, date);
        reservations.add(reservation);

        return reservation.getId();
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {
        RoomReservation roomReservation = null;
        for (RoomReservation r : reservations) {
            if (r.getId().equals(reservationId)) {
                roomReservation = r;
            }
        }

        if (roomReservation == null) {
            throw new ReservationNotFoundException("Reservation not found");
        }

        roomReservation.setConfirmed(true);
        return roomReservation.getId();
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
        Room room = null;
        RoomReservation reservation = null;
        for (Room r : rooms) {
            if (r.getId().equals(roomId)) {
                room = r;
            }
        }

        if (room == null) {
            throw new RoomNotFoundException("Room not found");
        }

        for (RoomReservation r : reservations) {
            if (r.getRentedRoom().getId().equals(roomId) && r.getDate().equals(date)) {
                reservation = r;
            }
        }

        return reservation != null;
    }

    @Override
    public int getNumberOfUnconfirmedReservation(LocalDate date) {
        int numberOfUnconfirmedReservations = 0;
        for (RoomReservation r : reservations) {
            if (r.isConfirmed() == false) {
                numberOfUnconfirmedReservations++;
            }
        }
        return numberOfUnconfirmedReservations;
    }

    @Override
    public Collection<String> getRoomIdsReservedByClient(String clientId) throws ClientNotFoundException {

        Client client = null;
        for (Client c : clients) {
            if (c.getId().equals(clientId)) {
                client = c;
            }
        }

        if (client == null) {
            throw new ClientNotFoundException("Client not found");
        }

        List<String> roomsReservedByClient = new ArrayList<>();
        for (RoomReservation r : reservations) {
            if (r.getRentingClient().getId().equals(client.getId())) {
                roomsReservedByClient.add(r.getId());
            }
        }

        return roomsReservedByClient;
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
