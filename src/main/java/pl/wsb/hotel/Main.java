package pl.wsb.hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Room roomNumberOne = new Room("1", 12, 1, false, 2000, 2, true, true);
        Client clientNumberOne = new Client("1",
                "Adam",
                "Smith",
                LocalDate.of(2000, 10, 1), "adam.smith@gmail.com",
                "123456789",
                "New York");
        RoomReservation reservationNumberOne = new RoomReservation(clientNumberOne, roomNumberOne, LocalDate.now());
        reservationNumberOne.confirmReservation();
        System.out.printf("%s", reservationNumberOne);
    }
}
