package com.javarush.test.level08.lesson06.task05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Четыре метода
Реализовать 4 метода. Они должны возвращать список,
который лучше всего подходит для выполнения данных операций (быстрее всего справится с большим количеством операций).
Ничего измерять не нужно.
*/

public class Solution
{
    public static List  getListForGet()
    {
        //Напишите тут ваш код
        ArrayList list = new ArrayList();
        /*
        for (int i = 0; i < 10000; i++) {
            Integer value = new Integer(i);
            list.add(value);
        }
        */
        return list;
    }

    public static List  getListForSet()
    {
        //Напишите тут ваш код
        ArrayList list = new ArrayList();
        return list;
    }

    public static List  getListForAddOrInsert()
    {
        //Напишите тут ваш код
        LinkedList linkedList = new LinkedList();
        return linkedList;
    }

    public static List  getListForRemove()
    {
        //Напишите тут ваш код
        LinkedList linkedList = new LinkedList();
        return linkedList;
    }
}
