package com.javarush.test.level15.lesson12.bonus02;

public class LatteMaker extends DrinkMaker {
    protected void getRightCup() {
        System.out.println("Берем чашку для латте");
    }
    protected void putIngredient() {
        System.out.println("Делаем кофе");
    }
    protected void pour() {
        System.out.println("Заливаем молоком с пенкой");
    }
}