package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int a = 7;
        Integer b = 9;
        Solution s = new Solution();
        s.print(a);
        s.print(b);
    }

    //Напишите тут ваши методы
    public void print(int a) {
        System.out.println("public void print(int a) = " + a);
    }
    public void print(Integer b) {
        System.out.println("public void print(Integer b) = " + b);
    }
}
