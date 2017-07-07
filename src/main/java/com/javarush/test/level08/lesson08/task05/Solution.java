package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(2);
        set.add(2);
        set.add(2);

        //for (Integer val : set)
        //    System.out.println(val);

        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }

    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        String[] lastname = {"Иванов", "Петров", "Сидоров", "Болдин", "Кузлякин", "Гребень", "Воля", "Волшебный", "Сухомлинов", "Арбатский"};
        String[] firstname = {"Сергей", "Николай", "Сергей", "Иван", "Егор", "Владимир", "Сергей", "Егор", "Петр", "Николай"};

        for (int i = 0; i < 10; i++)
            map.put(lastname[i], firstname[i]);

        /*
        for (Map.Entry<String, String> pair : map.entrySet())
            System.out.println(pair.getKey() + " : " + pair.getValue());
        */

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        HashSet<String> set = new HashSet<String>();

        // Формируем уникальный список имен
        for (Map.Entry<String, String> pair : map.entrySet())
            set.add(pair.getValue());

        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

        // Формируем список имен и частоту их вхождения
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String firstname = pair.getValue();
            if (hashmap.containsKey(firstname))
                hashmap.put(firstname, (hashmap.get(firstname) + 1));
            else
                hashmap.put(firstname, 1);
        }

        /*
        System.out.println("+++");
        for (String val : set)
            System.out.println(val);
        */

        /*
        System.out.println("===");
        for (Map.Entry<String, Integer> pair : hashmap.entrySet())
            System.out.println(pair.getKey() + " | " + pair.getValue());
        */

        for (Map.Entry<String, Integer> pair : hashmap.entrySet())
            if (pair.getValue() > 1)
                removeItemFromMapByValue(map, pair.getKey());

        /*
        System.out.println("---remove---");
        for (Map.Entry<String, String> pair : map.entrySet())
            System.out.println(pair.getKey() + " : " + pair.getValue());
        */
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
