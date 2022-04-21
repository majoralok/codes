package com.java.codes.singleton;

public class EasySingleton extends Object {

    private EasySingleton(){}

    private static final EasySingleton INSTANCE = new EasySingleton();

    public static EasySingleton getEasySingleton() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
