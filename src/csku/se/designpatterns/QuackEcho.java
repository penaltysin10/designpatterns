package csku.se.designpatterns;

import java.io.PrintStream;

public class QuackEcho implements Quackable {

    Quackable duck;

    public QuackEcho(Quackable duck){
        this.duck = duck;
    }

    public QuackEcho(QuackCounter quackCounter){
        this.duck = quackCounter;
    }

    @Override
    public void quack() {
        duck.quack();
        System.out.print("Echo: " + "");
        duck.quack();
    }
}
