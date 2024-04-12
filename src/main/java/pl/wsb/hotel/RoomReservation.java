package pl.wsb.hotel;

import java.time.LocalDate;

public class RoomReservation {
    private Client rentingClient;
    private Room rentedRoom;
    private LocalDate date;
    private boolean isConfirmed;

    public Client getRentingClient() {
        return rentingClient;
    }

    public void setRentingClient(Client rentingClient) {
        this.rentingClient = rentingClient;
    }

    public Room getRentedRoom() {
        return rentedRoom;
    }

    public void setRentedRoom(Room rentedRoom) {
        this.rentedRoom = rentedRoom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public void confirmReservation() {
        this.isConfirmed = true;
    }

    public RoomReservation(Client rentingClient, Room rentedRoom, LocalDate date) {
        this.rentedRoom = rentedRoom;
        this.rentingClient = rentingClient;
        this.date = date;
        this.isConfirmed = false;
    }

    // generate to string with key: value pairs using : and newline as separator

    @Override
    public String toString() {
        return "rentingClient: " + this.rentingClient
                + "\nrentedRoom: " + this.rentedRoom
                + "\ndate: " + this.date
                + "\nisConfirmed: " + this.isConfirmed;
    }
}
