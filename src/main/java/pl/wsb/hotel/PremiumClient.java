package pl.wsb.hotel;

import java.time.LocalDate;

public class PremiumClient extends Client {
    private PremiumAccountType premium_account_type;

    public PremiumClient(
            String id,
            String firstName,
            String lastName,
            LocalDate birthDate,
            String email,
            String phoneNumber,
            String address,
            PremiumAccountType premium_account_type
    ) {
        super(id, firstName, lastName, birthDate, email, phoneNumber, address);
        this.premium_account_type = premium_account_type;
    }

    public PremiumAccountType getPremiumAccountType() {
        return premium_account_type;
    }

    public void setPremiumAccountType(PremiumAccountType premium_account_type) {
        this.premium_account_type = premium_account_type;
    }

    @Override
    public String getFullName() {
        return "[premium] " + super.getFullName();
    }
}
