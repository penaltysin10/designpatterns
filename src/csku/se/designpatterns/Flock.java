package csku.se.designpatterns;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    ArrayList quackers = new ArrayList();

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable)iterator.next();
            if (quacker.equals(quackers.get(0))){
                quacker.quack();
                quacker.quack();
                quacker.quack();
            }
            else quacker.quack();
        }
    }
}
