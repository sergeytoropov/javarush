package com.javarush.test.level20.lesson10.bonus01;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.test.level20.lesson10.bonus01.Solution.*;
import static com.javarush.test.level20.lesson10.bonus01.Solution.numbers;
import static org.junit.Assert.*;

public class SolutionTest {
    // Для данного N найдены следующие числа!
    private long N = 10000L;
    private long[] numbers = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L, 9474L};

    private long N2 = 10000000000L;
    private long[] numbers2 = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L,
            1741725L, 4210818L, 9800817L, 9926315L, 24678050L, 24678051L, 88593477L, 146511208L, 472335975L, 534494836L, 912985153L, 4679307774L};

    private int N3 = 10000;
    private int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474};

    private int N4 = 1;
    private int[] numbers4 = {};

    private long[][] map = {
            {0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L},
            {0L, 1L, 4L, 9L, 16L, 25L, 36L, 49L, 64L, 81L},
            {0L, 1L, 8L, 27L, 64L, 125L, 216L, 343L, 512L, 729L},
            {0L, 1L, 16L, 81L, 256L, 625L, 1296L, 2401L, 4096L, 6561L},
            {0L, 1L, 32L, 243L, 1024L, 3125L, 7776L, 16807L, 32768L, 59049L},
            {0L, 1L, 64L, 729L, 4096L, 15625L, 46656L, 117649L, 262144L, 531441L},
            {0L, 1L, 128L, 2187L, 16384L, 78125L, 279936L, 823543L, 2097152L, 4782969L},
            {0L, 1L, 256L, 6561L, 65536L, 390625L, 1679616L, 5764801L, 16777216L, 43046721L},
            {0L, 1L, 512L, 19683L, 262144L, 1953125L, 10077696L, 40353607L, 134217728L, 387420489L},
            {0L, 1L, 1024L, 59049L, 1048576L, 9765625L, 60466176L, 282475249L, 1073741824L, 3486784401L},
    };

    private void print() {
        int NNN = 2;
        int[] result = Solution.getNumbers(NNN);
        for (int index = 0; index < result.length; index++) {
            System.out.print(result[index] + ", ");
        }
        System.out.println();

        long[] aa = null;
        System.out.println("null " + aa);

        aa = new long[0];
        System.out.println("new long[0] " + aa);
    }

    @Test
    public void getNumbersLong() {
        assertArrayEquals(Solution.run(N), numbers);
        assertArrayEquals(Solution.run(N2), numbers2);

        assertArrayEquals(Solution.getNumbers(N3), numbers3);
        assertArrayEquals(Solution.getNumbers(N4), numbers4);
        //print();
    }

    @Test
    public void map() {
        /*
        for (int level = 0; level < Solution.map.length; level++) {
            String line = "{";
            for (int digit = 0; digit < Solution.map[level].length; digit++) {
                line += Solution.map[level][digit] + "L, ";
            }
            System.out.println(line.substring(0, line.lastIndexOf(", ")) + "},");
        }
        */
        assertArrayEquals(Solution.map, map);
    }

    @Test
    public void tree() {
        Set<Long> numbers = new HashSet<Long>();

        Solution.numbers.clear();
        Solution.tree(new long[] {0, 1, 2, 3, 4}, 1);

        numbers.clear();
        for (long i = 0; i < 5; i++) {
            numbers.add(i);
        }

        assertEquals(Solution.numbers, numbers);

        Solution.numbers.clear();
        Solution.tree(new long[] {0, 1, 4, 9, 16}, 2);

        numbers.clear();
        long[] array = {0, 1, 4, 9, 16, 2, 5, 10, 17, 8, 13, 20, 18, 25, 32};

        for (int index = 0; index < array.length; index++) {
            numbers.add(array[index]);
        }

        assertEquals(Solution.numbers, numbers);
    }
}