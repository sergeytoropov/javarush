package com.javarush.test.level08.lesson11.home09;

import java.util.Date;
import java.util.GregorianCalendar;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
        //boolean b = isDateOdd("MAY 1 2014");
        //System.out.println(b);
    }

    public static boolean isDateOdd(String date)
    {
        String[] monthsEn =
            { "January", "February", "March", "April", "May", "June",
              "July", "August", "September", "October", "November", "December" };

        String[] partsDate = date.split(" ");
        GregorianCalendar calendar = new GregorianCalendar();

        int month = 0;
        for (int i = 0; i < monthsEn.length; i++) {
            if (monthsEn[i].toUpperCase().equals(partsDate[0]))
                month = i;
        }

        calendar.set(Integer.parseInt(partsDate[2]), month, Integer.parseInt(partsDate[1]));

        System.out.println(calendar.getTime());
        System.out.println(calendar.get(calendar.DAY_OF_YEAR));

        if (calendar.get(calendar.DAY_OF_YEAR) % 2 == 0)
            return false;
        return true;
    }
}
