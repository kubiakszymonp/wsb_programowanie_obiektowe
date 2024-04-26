package pl.wsb.hotel;

public class LuggageService extends SpecialService {

    @Override
    void orderService() {
        System.out.println("Your luggage is safely stored with us!");
    }

    @Override
    double getServicePrice(String currency) {
        if (currency.equals("PLN")) {
            return 50.0;
        }
        else if (currency.equals("USD")) {
            return 12.0;
        }
        else {
            throw new RuntimeException("Currency not supported");
        }
    }

    @Override
    boolean canClientUseIt(Client client) {
        return client.getAge() > 10;
    }
}
