package pl.wsb.hotel;

public abstract class SpecialService {
    private String name;

    abstract void orderService();
    abstract double getServicePrice(String currency);
    abstract boolean canClientUseIt(Client client);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

