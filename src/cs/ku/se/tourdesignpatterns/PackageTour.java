package cs.ku.se.tourdesignpatterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackageTour implements Tour {

    private String packageName;
    private List<Tour> tours = new ArrayList<>();

    public PackageTour(String packageName){
        this.packageName = packageName;
    }

    public void addTour(Tour tour){
        tours.add(tour);
    }

    public String removeTour(String nameTour){
        boolean hasTour = false;
        for (Tour t: tours) {
            if (t.getName().equals(nameTour)){
                hasTour = true;
                tours.remove(t);
                break;
            }
        }
        if (hasTour) return "Remove, " + nameTour;
        else throw new IllegalArgumentException(nameTour + " not in package.");
    }

    @Override
    public String getName() {
        List<String> nameTour = new ArrayList<>();
        for (Tour t : tours){
            nameTour.add(t.getName());
        }
        return "Package: " + packageName + ", Tour: " + String.join(", ", nameTour);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Tour t : tours)
            total += t.getPrice();
        return total*0.9;
    }

    @Override
    public int getAvailableSeats() {
        List<Integer> allAvailableSeats = new ArrayList<>();
        for (Tour t : tours){
            allAvailableSeats.add(t.getAvailableSeats());
        }
        return Collections.min(allAvailableSeats);
    }
}
