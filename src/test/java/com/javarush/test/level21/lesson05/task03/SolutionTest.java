package com.javarush.test.level21.lesson05.task03;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test001() {
        Solution solutionNull = new Solution(0, null, 0.0d, null, null);
        Solution solution1 = new Solution(11, "number1", 11d, new Date(), solutionNull);
        Solution solution11 = new Solution(11, "number1", 11d, new Date(), null);
        Solution solution2 = new Solution(22, "number2", 22d, new Date(), solutionNull);

        assertFalse(solution1.equals(null));
        assertTrue(solutionNull.equals(solutionNull));
        assertFalse(solution1.equals(new Integer(11)));
        assertFalse(solution1.equals(solution11));
        assertTrue(solution1.hashCode() == solution11.hashCode());

        assertTrue("str".equals("str"));
    }
}