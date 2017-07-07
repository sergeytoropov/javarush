package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int a1 = 3;
        int a2 = 5;

        long a3 = 7;
        long a4 = 1;

        double a5 = 5.4;
        double a6 = 1.999;

        System.out.println(min(a1, a2));
        System.out.println(min(a3, a4));
        System.out.println(min(a5, a6));
    }

    //Напишите тут ваши методы
    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static long min(long a, long b) {
        return a < b ? a : b;
    }

    public static double min(double a, double b) {
        return a < b ? a : b;
    }
}
