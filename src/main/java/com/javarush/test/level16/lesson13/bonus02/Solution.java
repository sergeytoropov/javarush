package com.javarush.test.level16.lesson13.bonus02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new Thread01());
        threads.add(new Thread02());
        threads.add(new Thread03());
        threads.add(new Thread04());
        threads.add(new Thread05());
    }
}

class Thread01 extends Thread {

    public Thread01() {
    }

    @Override
    public void run() {
        while (true) {
        }
    }
}

class Thread02 extends Thread {

    public Thread02() {
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        try {
            while (true) {
                if (thread.isInterrupted()) {
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}

class Thread03 extends Thread {

    public Thread03() {
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        try {
            while (!thread.isInterrupted()) {
                System.out.println("Ура");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {

        }
    }
}

class Thread04 extends Thread implements Message {

    public Thread04() {
    }

    @Override
    public void showWarning() {
        try {
            interrupt();
            join();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (!thread.isInterrupted()) {
        }
    }
}

class Thread05 extends Thread {

    public Thread05() {
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();

        try {
            while (true) {
                if (thread.isInterrupted()) {
                    throw new InterruptedException();
                }

                try {
                    String line = reader.readLine();
                    if ("N".equals(line)) {
                        break;
                    }
                    list.add(Integer.parseInt(line));
                } catch (IOException e) {
                } catch (NumberFormatException e) {
                }
            }

            Integer sum = 0;
            for (Integer value : list) {
                sum += value;
            }
            System.out.println("" + sum);

        } catch (InterruptedException e) {
        }
    }
}