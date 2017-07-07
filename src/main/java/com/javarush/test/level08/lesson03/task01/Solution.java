package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        Set<String> hash = new HashSet<String>();
        hash.add("арбуз");
        hash.add("банан");
        hash.add("вишня");
        hash.add("груша");
        hash.add("дыня");
        hash.add("ежевика");
        hash.add("жень-шень");
        hash.add("земляника");
        hash.add("ирис");
        hash.add("картофель");

        for (String s : hash) {
            System.out.println(s);
        }

        /*
        System.out.println("Again");
        Iterator<String> iter = hash.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            System.out.println(s);
        }

        Iterator<String> iterator = hash.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.print(s + ", ");
        }
        */


    }
}
