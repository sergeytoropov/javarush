package com.javarush.test.level10.lesson11.home05;

import com.sun.swing.internal.plaf.metal.resources.metal_pt_BR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).
Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {
            alphabet.add( (char) ('а'+i));
        }
        alphabet.add(6,'ё');

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add( s.toLowerCase());
        }


        //Напишите тут ваш код
        /*
        String[] array = new String[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine().toLowerCase();
        }
        */

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character ch : alphabet)
            map.put(ch, 0);

        for (String s : list) {
            char[] exp = s.toCharArray();
            for (char literal : exp) {
                for (Character ch : alphabet) {
                    if (literal == ch) {
                        map.put(literal, map.get(literal) + 1);
                        break;
                    }
                }
            }
        }

        for (Character ch : alphabet)
            System.out.println(ch + " " + map.get(ch));

        //for (Map.Entry<Character, Integer> pair : map.entrySet())
        //    System.out.println(pair.getKey() + " : " + pair.getValue());
    }

}
