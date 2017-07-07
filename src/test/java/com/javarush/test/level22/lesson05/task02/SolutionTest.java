package com.javarush.test.level22.lesson05.task02;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() throws Solution.TooShortStringException {
        final String tab = "\t";
        String s = "Cat\tis not\tdog!";

        assertEquals("is not", Solution.getPartOfString(s));
    }
}