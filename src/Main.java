import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Client klien1 = new Client("1", "ImieTest", "NaziwskoTest", LocalDate.of(1999, 12, 1));
//        System.out.printf("Years: %s \n", klien1.getAge());
//        System.out.printf("%s", klien1.getName());


        Room roomNumberOne = new Room("1", 12, 1, false, 2000, 2);
        Client clientNumberOne = new Client("1", "Adam", "Smith", LocalDate.of(2000, 10, 1));
        RoomReservation reservationNumberOne = new RoomReservation(clientNumberOne, roomNumberOne, LocalDate.now());
        reservationNumberOne.confirmReservation();

        System.out.printf("%s", reservationNumberOne);
    }
}