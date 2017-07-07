package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread spth1 = new SpecialThread();
        SpecialThread spth2 = new SpecialThread();
        SpecialThread spth3 = new SpecialThread();
        SpecialThread spth4 = new SpecialThread();
        SpecialThread spth5 = new SpecialThread();
        list.add(new Thread(spth1));
        list.add(new Thread(spth2));
        list.add(new Thread(spth3));
        list.add(new Thread(spth4));
        list.add(new Thread(spth5));
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
