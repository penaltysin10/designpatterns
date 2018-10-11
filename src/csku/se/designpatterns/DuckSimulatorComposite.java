package csku.se.designpatterns;

public class DuckSimulatorComposite {

    public void simulate(Quackable duck){
        duck.quack();
    }

    public void simulate(AbstractDuckFactory duckFactory){
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        Flock flockOfDuck = new Flock();
        flockOfDuck.add(mallardDuck);
        flockOfDuck.add(redheadDuck);
        flockOfDuck.add(rubberDuck);
        flockOfDuck.add(goose);
        flockOfDuck.add(pigeon);

        simulate(flockOfDuck);

        System.out.println("\nThe ducks quack " + QuackCounter.getQuacks() + " times");

    }

    public static void main(String[] args) {
        DuckSimulatorComposite simulator = new DuckSimulatorComposite();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

}
