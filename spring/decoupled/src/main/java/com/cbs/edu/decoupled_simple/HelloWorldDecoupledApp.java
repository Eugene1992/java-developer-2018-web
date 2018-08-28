package com.cbs.edu.decoupled_simple;

public class HelloWorldDecoupledApp {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello world!");
        }
    }
}
