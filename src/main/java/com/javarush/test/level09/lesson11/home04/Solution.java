package com.javarush.test.level09.lesson11.home04;

import org.omg.DynamicAny._DynAnyFactoryStub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.text.DateFormatSymbols;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //for (int i = 0; i < 12; i++) {

        String s = reader.readLine();
        //String s = ""; s += (100+i); s = s.substring(1, 3); s = s + "/01/1990";
        //System.out.println(s);
        String[] array = s.split("/");

        GregorianCalendar calendar = new GregorianCalendar();
        int year = Integer.parseInt(array[2]);
        int month = Integer.parseInt(array[0]) - 1;
        int day = Integer.parseInt(array[1]);
        calendar.set(year, month, day);

        //String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        //DateFormatSymbols dfs = new DateFormatSymbols();
        //dfs.setShortMonths(months);

        //System.out.println(year + " : " + month + " : " + day);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        //SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy", dfs);
        Date date = calendar.getTime();
        System.out.println(sdf.format(date).toUpperCase());
        //}
    }
}
