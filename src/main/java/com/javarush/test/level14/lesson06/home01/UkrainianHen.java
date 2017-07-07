package com.javarush.test.level14.lesson06.home01;

class UkrainianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 33;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " +
                this.getCountOfEggsPerMonth
                        () +
                " " +
                "яиц в месяц.";
    }
}