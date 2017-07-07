package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 12 2012".
*/

import java.util.Date;
import java.text.SimpleDateFormat;

public class Solution
{
    public static void main(String[] args)
    {
        //Напишите тут ваш код
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        System.out.println(sdf.format(date));
    }
}
