package com.javarush.test.level21.lesson05.task02;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void equals() {
        Set<Solution> s = new HashSet<Solution>();
        Solution s1 = new Solution("Mickey", "Mouse");
        s.add(s1);

        Solution s2 = new Solution("Mickey", "Mouse");
        System.out.println(s.contains(s2));

        assertTrue(s1.equals(s2));
        assertEquals(s1, s2);

        Solution s3;
        Solution s4;

        System.out.println("Part 1");

        s3 = new Solution(null, null);
        s4 = new Solution(null, null);

        assertEquals(s3.hashCode(), s4.hashCode());
        assertTrue(s3.equals(s4));
        assertEquals(s3, s4);

        System.out.println("Part 2");

        s3 = new Solution("Mick", null);
        s4 = new Solution("Mick", null);

        assertEquals(s3.hashCode(), s4.hashCode());
        assertTrue(s3.equals(s4));
        assertEquals(s3, s4);

        System.out.println("Part 3");

        s3 = new Solution(null, "Mick");
        s4 = new Solution("Michel", null);

        assertNotEquals(s3.hashCode(), s4.hashCode());
        assertFalse(s3.equals(s4));
        assertNotEquals(s3, s4);
    }
}