package pl.wsb.hotel;

public class Room {
    private String id;
    private double area;
    private int floor;
    private boolean hasKingSizeBed;
    private double price;
    private int numberOfWindows;
    private boolean hasBalcony;
    private boolean hasBathroom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean getHasKingSizeBed() {
        return hasKingSizeBed;
    }

    public void setHasKingSizeBed(boolean hasKingSizeBed) {
        this.hasKingSizeBed = hasKingSizeBed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public boolean getHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean getHasBathroom() {
        return hasBathroom;
    }

    public void setHasBathroom(boolean hasBathroom) {
        this.hasBathroom = hasBathroom;
    }

    public Room(String id,
            double area,
            int floor,
            boolean hasKingSizeBed,
            double price,
            int numberOfWindows,
            boolean hasBalcony,
            boolean hasBathroom) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.price = price;
        this.numberOfWindows = numberOfWindows;
        this.hasBalcony = hasBalcony;
        this.hasBathroom = hasBathroom;
    }

    @Override
    public String toString() {
        return "id: " + this.id
                + "\narea: " + this.area
                + "\nfloor: " + this.floor
                + "\nhasKingSizeBed: " + this.hasKingSizeBed
                + "\nprice: " + this.price
                + "\nnumberOfWindows: " + this.numberOfWindows
                + "\nhasBalcony: " + this.hasBalcony
                + "\nhasBathroom: " + this.hasBathroom;
    }
}
