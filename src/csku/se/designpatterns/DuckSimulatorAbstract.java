package csku.se.designpatterns;

public class DuckSimulatorAbstract {

    public void simulate(Quackable duck){
        duck.quack();
    }

    public void simulate(AbstractDuckFactory duckFactory){
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    public static void main(String[] args) {
        DuckSimulatorAbstract simulator = new DuckSimulatorAbstract();
        AbstractDuckFactory duckFactory = new DuckFactory();
        System.out.println("\nSimulator : AbstractFactory, use non-decorator");
        simulator.simulate(duckFactory);

        AbstractDuckFactory countingFactory = new CountingDuckFactory();
        System.out.println("\nSimulator : AbstractFactory, use counter decorator");
        simulator.simulate(countingFactory);

        AbstractDuckFactory countingAndEchoFactory = new CountingAndEchoDuckFactory();
        System.out.println("\nSimulator : AbstractFactory, use counter and echo decorator");
        simulator.simulate(countingAndEchoFactory);
    }
}
