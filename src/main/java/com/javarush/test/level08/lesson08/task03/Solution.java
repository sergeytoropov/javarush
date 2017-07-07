package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        String[] lastname = {"Петров", "Сидоров", "Иванов", "Залевский", "Попов", "Николаев", "Болдин", "Карач", "Краев", "Кулаков"};
        String[] firstname = {"Сергей", "Иван", "Николай", "Роман", "Егор", "Игорь", "Михаил", "Владимир", "Дмитрий", "Вячеслав"};
        for (int i = 0; i < 10; i++) {
            map.put(lastname[i], firstname[i]);
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String firstname = pair.getValue();
            if (firstname.equals(name))
                count += 1;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String lastname = pair.getKey();
            if (lastname.equals(familiya))
                count += 1;
        }
        return count;
    }
}
