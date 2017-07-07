package com.javarush.test.level15.lesson12.bonus02;

public class TeaMaker extends DrinkMaker {
    protected void getRightCup() {
        System.out.println("Берем чашку для чая");
    }
    protected void putIngredient() {
        System.out.println("Насыпаем чай");
    }
    protected void pour() {
        System.out.println("Заливаем водой");
    }
}
