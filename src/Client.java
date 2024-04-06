import java.time.LocalDate;
import java.time.Period;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client(String id,
            String firstName,
            String lastName,
            LocalDate birthDate,
            String email,
            String phoneNumber,
            String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getAge() {
        Period periodTime;
        periodTime = this.birthDate.until(LocalDate.now());
        return periodTime.getYears();
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return "id: " + this.id
                + "\nfirstName: " + this.firstName
                + "\nlastName: " + this.lastName
                + "\nbirthDate: " + this.birthDate
                + "\nemail: " + this.email
                + "\nphoneNumber: " + this.phoneNumber
                + "\naddress: " + this.address;
    }
}
