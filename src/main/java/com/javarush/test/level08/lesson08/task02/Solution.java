package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashSet<Integer> set = createSet();
        //for (Integer i : set)
        //    System.out.println(i);

        set = removeAllNumbersMoreThen10(set);
        for (Integer i : set)
            System.out.println(i);
    }

    public static HashSet<Integer> createSet()
    {
        //Напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        while (i < 20) {
            set.add(i * 2);
            i++;
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set)
    {
        //Напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (Integer value : set)
            if (value > 10)
                list.add(value);

        for (Integer value : list)
            set.remove(value);

        return set;
    }
}
