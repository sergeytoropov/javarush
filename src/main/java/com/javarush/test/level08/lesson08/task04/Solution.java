package com.javarush.test.level08.lesson08.task04;

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        String[] lastname = {"Сталлоне", "Петров", "Иванов", "Сидоров", "Николаев", "Гребень", "Михалков", "Залевский", "Болдин", "Комаров"};

        for (int i = 0; i < lastname.length; i++) {
            Date date = new Date();
            date.setYear(1980);
            date.setMonth(i);
            date.setDate(1);

            map.put(lastname[i], date);
        }
        //map.put("Сталлоне", new Date("JUNE 1 1980"));
        /*
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        */
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        for (Map.Entry<String, Date> pair : map.entrySet()) {
            int month = pair.getValue().getMonth();
            // Месяцы начинаются с нуля
            if (month >= 5 && month <= 7)
                list.add(pair.getKey());
                //System.out.println(pair.getKey());
        }

        for (String key : list) {
            map.remove(key);
        }

        /*
        System.out.println("---");
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        */
    }
}
