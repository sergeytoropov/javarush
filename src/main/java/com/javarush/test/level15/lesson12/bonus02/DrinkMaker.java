package com.javarush.test.level15.lesson12.bonus02;

public abstract class DrinkMaker {
    protected abstract void getRightCup(); //выбрать подходящую чашку
    protected abstract void putIngredient(); //положить ингредиенты
    protected abstract void pour(); // залить жидкостью

    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
