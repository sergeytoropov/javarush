package com.javarush.test.level14.lesson06.home01;

class RussianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 44;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " +
                this.getCountOfEggsPerMonth() + " " +
                "яиц в месяц.";
    }
}
