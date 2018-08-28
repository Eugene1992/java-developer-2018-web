package com.cbs.edu;

public class Juggler implements Performer {
    private int bags;

    public Juggler(int bags) {
        this.bags = bags;
    }

    @Override
    public void perform() {
        System.out.println("Juggling " + bags + " bags!");
    }
}
