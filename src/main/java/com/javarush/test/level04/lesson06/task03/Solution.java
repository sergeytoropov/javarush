package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n1 = Integer.parseInt(reader.readLine());
        Integer n2 = Integer.parseInt(reader.readLine());
        Integer n3 = Integer.parseInt(reader.readLine());
        Integer s1, s2, s3;

        s1 = n1;
        s2 = n2;
        s3 = n3;
        if (n2 > s1) { s1 = n2; s2 = n1; s3 = n3; }
        if (n3 > s1) { s1 = n3; s2 = n1; s3 = n2; }
        System.out.println(s1);

        if (s2 > s3)
        {
            System.out.println(s2);
            System.out.println(s3);
        }
        else
        {
            System.out.println(s3);
            System.out.println(s2);
        }


    }
}
