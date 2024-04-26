package pl.wsb.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
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

}
