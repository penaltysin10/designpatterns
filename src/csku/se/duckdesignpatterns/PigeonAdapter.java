package csku.se.duckdesignpatterns;

public class PigeonAdapter implements Quackable {

    Pigeon pigeon;

    public PigeonAdapter(Pigeon pigeon){
        this.pigeon = pigeon;
    }

    @Override
    public void quack() {
        this.pigeon.coo();
    }
}
