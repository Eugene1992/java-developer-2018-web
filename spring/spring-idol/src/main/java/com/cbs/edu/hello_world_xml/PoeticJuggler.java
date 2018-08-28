package com.cbs.edu.hello_world_xml;

public class PoeticJuggler extends Juggler {
    private Poem poem;

    public PoeticJuggler(Poem poem, int beanBags) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perform() {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
