package com.java.codes.proxy;

public class Person implements Human{
    @Override
    public void walk(int m) {
        System.out.println("Waling");
    }

    @Override
    public void talk(int m) {
        System.out.println("Talking");
    }
}
