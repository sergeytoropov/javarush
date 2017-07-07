package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        String[] names = {"Барсик", "Шустрик", "Петя", "Жулик", "Башмачок", "Увалень", "Пень", "Йога", "Мурзик", "Вася"};
        //String[] cats = {"Кот1", "Кот2", "Кот3", "Кот4", "Кот5", "Кот6", "Кот7", "Кот8", "Кот9", "Кот10"};

        for (int i = 0; i < 10; i++)
            map.put(names[i], new Cat(names[i]));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //Напишите тут ваш код
        HashSet<Cat> set = new HashSet<Cat>();

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            set.add(pair.getValue());
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
