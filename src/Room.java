public class Room {
    private String id;
    private double area;
    private int floor;
    private boolean hasKingSizeBed;
    private double price;
    private int numberOfWindows;


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

    public Room(String id, double area, int floor, boolean hasKingSizeBed, double price, int numberOfWindows){
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.price = price;
        this.numberOfWindows = numberOfWindows;
    }
    @Override
    public String toString(){
        return "\nRoom " + this.id + " " + this.area + " " + this.floor + " " + this.hasKingSizeBed + " " + this.price + " " + this.numberOfWindows + "\n";

    }
}
