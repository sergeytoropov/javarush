package com.javarush.test.level14.lesson06.home01;

class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 11;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " +
                this.getCountOfEggsPerMonth()
                + " " +
                "" +
                "яиц в месяц.";
    }
}