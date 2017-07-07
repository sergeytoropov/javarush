package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //Напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        String[] array = {"Лара", "Лор", "Лама", "Лом", "Ладья", "Ларец", "Лелик", "Лодка", "Лагерь", "Ладошка", "Ларек", "Лель", "Лемма", "Лекция", "Лед", "Легкие", "Лик", "Лес", "Лера", "Латок"};
        for (int i = 0; i < array.length; i++)
            set.add(array[i]);
        return set;
    }
}
