package com.javarush.test.level17.lesson10.home01;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void main() {
        System.out.println("Begin");

        Solution s = new Solution();

        s.add(new Long(5));

        ArrayList<Long> ss = new ArrayList<Long>();

        System.out.println("End");
    }
}