import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Client(String id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate; // TODO dodać więcej bezsensownych pól o kliencie
    }
    public int getAge(){
        Period periodTime;
        periodTime = this.birthDate.until(LocalDate.now());
        return periodTime.getYears();
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }
}
