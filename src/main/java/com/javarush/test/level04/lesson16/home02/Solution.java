package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n1 = Integer.parseInt(reader.readLine());
        Integer n2 = Integer.parseInt(reader.readLine());
        Integer n3 = Integer.parseInt(reader.readLine());
        Integer n = n1;
        if (n2 >= n1 && n2 <= n3 || n2 <= n1 && n2 >= n3)
            n = n2;
        if (n3 >= n1 && n3 <= n2 || n3 <= n1 && n3 >= n2)
            n = n3;
        System.out.println(n);
    }
}
