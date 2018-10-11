package csku.se.designpatterns;

public class DuckSimulator {

    public void simulate(Quackable duck){
        duck.quack();
    }

    public void simulate() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable rubberDuck = new RubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator : With Adapter Patterns");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);

        System.out.println("\nDuck Simulator : With Decorator Patterns");
        // if use QuackCounter, method getQuack return number of quack = 3 times
        Quackable mallardDuck1 = new QuackCounter(new QuackEcho(new MallardDuck()));
        Quackable redheadDuck1 = new QuackCounter(new QuackEcho(new RedheadDuck()));
        Quackable rubberDuck1 = new QuackCounter(new QuackEcho(new RubberDuck()));
        Quackable goose1 = new GooseAdapter(new Goose());
        Quackable pigeon1 = new PigeonAdapter(new Pigeon());
        simulate(mallardDuck1);
        simulate(redheadDuck1);
        simulate(rubberDuck1);
        simulate(goose1);
        simulate(pigeon1);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
         // if use QuackEcho, method getQuack return number of quack = 6 times
//        Quackable mallardDuck2 = new QuackEcho(new QuackCounter(new MallardDuck()));
//        Quackable redheadDuck2 = new QuackEcho(new QuackCounter(new RedheadDuck()));
//        Quackable rubberDuck2 = new QuackEcho(new QuackCounter(new RubberDuck()));
//        Quackable goose2 = new GooseAdapter(new Goose());
//        Quackable pigeon2 = new PigeonAdapter(new Pigeon());
//        simulate(mallardDuck2);
//        simulate(redheadDuck2);
//        simulate(rubberDuck2);
//        simulate(goose2);
//        simulate(pigeon2);
//        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");



    }

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }
}
