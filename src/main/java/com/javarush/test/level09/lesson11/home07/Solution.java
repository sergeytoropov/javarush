package com.javarush.test.level09.lesson11.home07;

/* Расставь модификаторы static
Расставь модификаторы static так, чтобы пример скомпилировался.
*/

public class Solution
{
    public static int A = 5;
    public static int B = 2 * A;
    public int C = A * B;
    public static int D = A * B;

    public static void main(String[] args)
    {
        Solution room = new Solution();
        room.A = 55;

        System.out.println(room.A);

        Solution.D = 5;
    }

    public int getA()
    {
        return A;
    }

}
