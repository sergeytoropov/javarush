package com.javarush.test.level14.lesson06.home01;

class MoldovanHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 22;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " +
                this.getCountOfEggsPerMonth() + " " +
                "яиц в месяц.";
    }
}