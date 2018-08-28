package com.cbs.edu;

import org.springframework.stereotype.Component;

@Component(value = "kenny")
public class PoeticPerformer implements Performer {
    @Override
    public void perform() {
        System.out.println("Juggling poetically!");
    }
}
