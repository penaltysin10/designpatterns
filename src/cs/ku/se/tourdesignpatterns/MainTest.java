package cs.ku.se.tourdesignpatterns;

public class MainTest {
    public static void main(String[] args) {
        SingleTour testSingle = new SingleTour("Khao Kho", 900, 8);
        PackageTour testPackageTour = new PackageTour("SSS");
        testPackageTour.addTour(testSingle);
        System.out.println(testPackageTour.removeTour("Khao Kho"));
    }
}
