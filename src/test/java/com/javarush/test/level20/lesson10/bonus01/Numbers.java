package com.javarush.test.level20.lesson10.bonus01;

import java.io.IOException;
import java.util.LinkedList;

public class Numbers {
    //private long N = 10000000000L;
    //private long N = 1000000000;
    private long N = 999999999;
    private LinkedList<Long> numbers = new LinkedList<Long>();

    public boolean sum(long n) {
        long sum = 0;
        char[] digits = String.valueOf(n).toCharArray();

        for (int index = 0; index < digits.length; index++) {
            long digit = digits[index] - '0';

            long mult = 1;
            for (int j = 0; j < digits.length; j++) {
                mult *= digit;
            }

            sum += mult;
            if (sum > n) {
                return false;
            }
        }

        return sum == n;
    }

    public void algorithm() {
        numbers.clear();

        for (long n = 0; n < N; n++) {
            if (sum(n)) {
                numbers.add(n);
            }
        }
    }

    public void print() {
        String line = "{";
        for (Long number: numbers) {
            line += number + "L, ";
        }
        System.out.println(line.substring(0, line.lastIndexOf(", ")) + "}");
    }

    public static void main(String[] args) throws IOException {
        Numbers numbers = new Numbers();
        numbers.algorithm();
        numbers.print();
    }
}
