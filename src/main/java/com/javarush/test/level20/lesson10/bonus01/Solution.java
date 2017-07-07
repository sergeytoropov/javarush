package com.javarush.test.level20.lesson10.bonus01;

import java.util.*;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/

public class Solution {
    public static int[] getNumbers(int N) {
        long[] answer = run((long) N);
        int[] result = new int[answer.length];

        for (int index = 0; index < answer.length; index++) {
            result[index] = (int) answer[index];
        }

        return result;
    }

    private static final int LEVELS = 10;
    private static final int DIGITS = 10;

    public static long[][] map;
    public static Set<Long> numbers;

    static {
        map = new long[LEVELS][DIGITS];

        for (int level = 0; level < map.length; level++) {
            for (int digit = 0; digit < map[level].length; digit++) {
                long result = 1;

                for (int index = 0; index <= level; index++) {
                    result *= digit;
                }

                map[level][digit] = result;
            }
        }

        numbers = new HashSet<Long>();
    }

    public static class Leaf {
        public int maxLevel;

        public int level;
        public long sum;

        public Leaf(int maxLevel) {
            this.maxLevel = maxLevel;
            this.level = 0;
            this.sum = 0;
        }

        public Leaf(int maxLevel, int level, long sum) {
            this.maxLevel = maxLevel;
            this.level = level;
            this.sum = sum;
        }
    }

    public static void node(Leaf parent, long[] digits, int currentIndex) {
        if (parent.level < parent.maxLevel) {

            for (int index = currentIndex; index < digits.length; index++) {
                Leaf leaf = new Leaf(parent.maxLevel, parent.level + 1, parent.sum + digits[index]);

                node(leaf, digits, index);
            }
        } else {
            numbers.add(parent.sum);
        }
    }

    public static void tree(long[] digits, int maxLevel) {
        Leaf root = new Leaf(maxLevel);

        for (int index = 0; index < digits.length; index++) {
            node(root, digits, index);
        }
    }

    public static void tree() {
        numbers.clear();

        for (int level = 0; level < map.length; level++) {
            tree(map[level], level + 1);
        }
    }

    // Возвращает true, если число удовлетворяет логику задачи
    public static boolean isNumber(Long number) {
        long sum = 0;
        char[] digits = String.valueOf(number).toCharArray();

        for (int index = 0; index < digits.length; index++) {
            long digit = digits[index] - '0';

            long mult = 1;
            for (int j = 0; j < digits.length; j++) {
                mult *= digit;
            }

            sum += mult;
            if (sum > number) {
                return false;
            }
        }

        return sum == number;
    }

    public static long[] run(long N) {
        tree();

        TreeSet<Long> answer = new TreeSet<Long>();

        for (Long number: numbers) {
            if (number > 0 && number < N && isNumber(number)) {
                answer.add(number);
            }
        }

        int index = 0;
        long[] digits = new long[answer.size()];

        for(Long number: answer) {
            digits[index++] = number;
        }

        return digits;
    }
}
