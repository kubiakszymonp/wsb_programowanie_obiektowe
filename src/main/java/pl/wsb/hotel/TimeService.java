package pl.wsb.hotel;

import java.time.LocalTime;

public class TimeService extends SpecialService {

    @Override
    void orderService() {
        System.out.println("Current time: " + LocalTime.now());
    }

    @Override
    double getServicePrice(String currency) {
        if (currency.equals("PLN")) {
            return 10.5;
        } else if (currency.equals("USD")) {
            return 3.1;
        } else {
            throw new RuntimeException("Currency not supported");
        }
    }

    @Override
    boolean canClientUseIt(Client client) {

        return true;
    }
}
