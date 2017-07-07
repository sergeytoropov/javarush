package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    public static Hippodrome game;

    private ArrayList<Horse> horses = null;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        for (String name: new String[] {"HorseA", "HorseB", "HorseC"}) {
            game.getHorses().add(new Horse(name, 3, 0));
        }
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses() {
        if (horses == null) {
            horses = new ArrayList<Horse>();
        }
        return horses;
    }

    public void move() {
        for (Horse horse: horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse hosrse: horses) {
            hosrse.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run() throws InterruptedException {
        for (int index = 1; index <= 100; index++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse winner = (horses != null && horses.size() > 0) ? horses.get(0) : new Horse("NULL", 0, 0);

        if (winner != null) {
            for (Horse horse: horses) {
                if (winner.getDistance() < horse.getDistance()) {
                    winner = horse;
                }
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
