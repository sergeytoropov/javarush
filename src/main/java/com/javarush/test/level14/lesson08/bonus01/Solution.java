package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try {
            String s = null;
            int length = s.length();
        } catch (Exception e) { // NullPointerException
            exceptions.add(e);
        }

        try {
            int[] arr = new int[10];
            int max = arr[11];
        } catch (Exception e) { // ArrayIndexOutOfBoundsException
            exceptions.add(e);
        }

        try {
            int[] arr = new int[-2];
        } catch (Exception e) { // NegativeArraySizeException
            exceptions.add(e);
        }

        try {
            int value = Integer.parseInt("abc");
        } catch (Exception e) { // NumberFormatException
            exceptions.add(e);
        }

        try {
            FileReader fReader = new FileReader("FileNotFound");
            BufferedReader reader = new BufferedReader(fReader);
        } catch(Exception e) { // FileNotFoundException
            exceptions.add(e);
        }

        try {
            Stack<String> stack = new Stack<String>();
            String s = stack.pop();
        } catch(Exception e) { // EmptyStackException
            exceptions.add(e);
        }

        try {
            Vector<String> vector = new Vector<String>();
            String s = vector.firstElement();
        } catch(Exception e) { // NoSuchElementException
            exceptions.add(e);
        }

        try {
            String siteUrl = "XYZ";
            URL url = new URL(siteUrl);
        }
        catch (Exception e) { // MalformedURLException
            exceptions.add(e);
        }

        try {
            SimpleDateFormat dateParser = new SimpleDateFormat("MM'/'dd'/'yyyy' 'H':'m':'s'.'SSS");
            String dateString = "05/18/2008 16:30:53"; //.700";
            Date d = dateParser.parse(dateString);
        } catch (Exception e) { // ParseException
            exceptions.add(e);
        }
    }
}
