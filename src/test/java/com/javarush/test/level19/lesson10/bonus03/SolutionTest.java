package com.javarush.test.level19.lesson10.bonus03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class SolutionTest {
    private InputStream in;
    private String fName1 = "page1.html";
    private String tagName1 = "span";

    @Before
    public void before() {
        in = System.in;
    }

    @After
    public void after() {
        System.setIn(in);
    }

    private void prepare(String fName) {
        StringBuffer sb = new StringBuffer();

        sb.append(fName).append("\n");
        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }

    @Test
    public void main() {
        prepare(fName1);
        Solution.main(new String[] {tagName1});

        assertEquals(tagName1, Solution.tagName);
        assertEquals(fName1, Solution.fName);
    }
}