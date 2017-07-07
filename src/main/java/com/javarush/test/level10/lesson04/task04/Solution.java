package com.javarush.test.level10.lesson04.task04;

/* Задача №4 на преобразование целых типов
Расставь где нужно оператор приведения типа:
short number = 9;
char zero = '0';
char nine = zero + number;
*/

public class Solution
{
    public static void main(String[] args)
    {
        short number = 9;
        char zero = '0';
        char nine = (char) (zero + number);

        int a = 257;
        int b = 4;
        int c = 3;
        int e = 2;
        double d = (byte) a + b/c/e;
        System.out.println(d);
        System.out.println(b/c/e);

        int dd = b/c;
        System.out.println(dd);
    }
}
