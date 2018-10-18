package cs.ku.se.tourdesignpatterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TourTestProgram {

    private SingleTour tour1;
    private SingleTour tour2;
    private SingleTour tour3;
    private PackageTour packageTour;

    @BeforeEach
    void setUp() {
        tour1 = new SingleTour("Khao Kho", 950, 5);
        tour2 = new SingleTour("Phu Thap Boek", 900, 7);
        tour3 = new SingleTour("Mountain wind farm", 1050, 6);
        packageTour = new PackageTour("Phetchabun Tour");
    }

    @Test
    public void singleTour_reserved_seats_more_available_seats(){
        IllegalArgumentException ex =  assertThrows(IllegalArgumentException.class, () -> {tour1.reserved(6);});
        assertEquals("You can not reserved seats a tour.", ex.getMessage());
    }

    @Test
    public void singleTour_reserved_seats_less_or_equal_available_seat(){
        tour1.reserved(3);
        assertEquals(3, tour1.getReservedSeats());
    }

    @Test
    public void singleTour_get_available_seats(){
        tour1.reserved(2);
        assertEquals(3, tour1.getAvailableSeats());
    }

    @Test
    public void packageTour_available_seats_equal_min_seats_all_of_tour(){
        packageTour.addTour(tour1);
        packageTour.addTour(tour2);
        packageTour.addTour(tour3);
        assertEquals(5, packageTour.getAvailableSeats());
    }

    @Test
    public void packageTour_price_of_package(){
        packageTour.addTour(tour1);
        packageTour.addTour(tour2);
        packageTour.addTour(tour3);
        assertEquals(2610, packageTour.getPrice());
    }

    @Test
    public void packageTour_remove_tour_if_tour_not_in_package(){
        packageTour.addTour(tour1);
        packageTour.addTour(tour2);
        packageTour.addTour(tour3);
        IllegalArgumentException ex =  assertThrows(IllegalArgumentException.class,
                () -> {packageTour.removeTour("Samui");});
        assertEquals("Samui not in package.", ex.getMessage());
    }

    @Test
    public void packageTour_remove_tour_success(){
        packageTour.addTour(tour1);
        packageTour.addTour(tour2);
        packageTour.addTour(tour3);
        assertEquals("Remove, Khao Kho", packageTour.removeTour("Khao Kho"));
    }

    @Test
    public void singleTour_set_price(){
        tour1.setPrice(1000);
        assertEquals(1000, tour1.getPrice());
    }
}