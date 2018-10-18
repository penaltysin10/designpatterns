package cs.ku.se.tourdesignpatterns;

public class SingleTour implements Tour {

    private String name;
    private double price;
    private int allSeats;
    private int reservedSeats;

    public SingleTour(String name, double price, int allSeats){
        this.name = name;
        this.price = price;
        this.allSeats = allSeats;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public void reserved(int seats){
        if ((reservedSeats + seats) <= getAvailableSeats()){
            reservedSeats += seats;
        }
        else throw new IllegalArgumentException("You can not reserved seats a tour.");
    }
    public int getReservedSeats(){
        return reservedSeats;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getAvailableSeats() {
        return allSeats - reservedSeats;
    }

    public String toString(){
        return "Tour: " + name + ", Price: " + price + "All seats: " + allSeats;
    }
}
