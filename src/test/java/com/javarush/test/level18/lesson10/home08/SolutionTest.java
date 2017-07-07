package com.javarush.test.level18.lesson10.home08;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    final String path = "/Users/sit/github/javarush/src/test/java/com/javarush/test/level18/lesson10/home08/";
    InputStream in;

    @Before
    public void before() {
        in = System.in;
    }

    @After
    public void after() {
        System.setIn(in);
    }

    private void prepare(List<String> fileNames) {
        StringBuffer sb = new StringBuffer();

        for (String fName: fileNames) {
            sb.append(path + fName).append("\n");
        }
        sb.append("exit").append("\n");
        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }

    @Test
    public void main() {
        prepare(Arrays.asList("name1.txt", "name2.txt", "name3.txt"));
        Solution.main(null);
    }
}