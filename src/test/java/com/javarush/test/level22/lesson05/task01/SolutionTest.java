package com.javarush.test.level22.lesson05.task01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sit on 15.11.15.
 */
public class SolutionTest {
    @Test
    public void test() throws Solution.TooShortStringException {
        String input = "JavaRush - лучший сервис обучения Java.";
        String output = "- лучший сервис обучения";

        assertEquals(output, Solution.getPartOfString(input));
    }
}