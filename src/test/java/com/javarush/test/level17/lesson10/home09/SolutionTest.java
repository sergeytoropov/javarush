package com.javarush.test.level17.lesson10.home09;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    final String path = "/Users/sit/github/javarush/src/test/java/com/javarush/test/level17/lesson10/home09/";
    InputStream in;

    @Before
    public void init() {
        InputStream in = System.in;
    }

    private void prepare(String fNameAdd, String fNameRemove) {
        StringBuffer sb = new StringBuffer();
        sb.append(path + fNameAdd).append("\n");
        sb.append(path + fNameRemove).append("\n");

        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }

    @After
    public void finalize() {
        System.setIn(in);
    }

    @Test
    public void conditon1() {
        prepare("add.txt", "remove.txt");
        Solution.clear();
        Solution.main(null);

        assertEquals(new ArrayList<String>(Arrays.asList("111", "222", "444", "555", "666")), Solution.allLines);
        assertEquals(new ArrayList<String>(Arrays.asList("333", "777")), Solution.forRemoveLines);
    }

    @Test
    public void condition2() {
        prepare("add.txt", "remove2.txt");
        Solution.clear();
        Solution.main(null);

        assertEquals(new ArrayList<String>(), Solution.allLines);
        assertEquals(new ArrayList<String>(Arrays.asList("999")), Solution.forRemoveLines);
    }

    @Test
    public void condition3() {
        prepare("add.txt", "remove3.txt");
        Solution.clear();
        Solution.main(null);

        //assertEquals(new ArrayList<String>(Arrays.asList("111", "222", "333", "444", "555", "666", "777")), Solution.allLines);
        assertEquals(new ArrayList<String>(), Solution.allLines);
        assertEquals(new ArrayList<String>(Arrays.asList("333", "777", "999")), Solution.forRemoveLines);
    }
}