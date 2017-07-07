package com.javarush.test.level14.lesson08.bonus03;

public class Singleton
{
    private static Singleton instance = null;

    private Singleton() { }

    public static Singleton getInstance() {
        if (Singleton.instance == null) {
            Singleton.instance = new Singleton();
        }
        return Singleton.instance;
    }
}
