package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here - напиши код тут
        String[] monthsEn =
            { "January", "February", "March", "April", "May", "June",
              "July", "August", "September", "October", "November", "December" };

        String[] monthsRu =
            { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
              "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        for (int i = 0; i < monthsEn.length; i++)
            if (monthsEn[i].toUpperCase().equals(month.toUpperCase()))
                System.out.println(monthsEn[i] + " is " + (i + 1) + " month");
    }

}
