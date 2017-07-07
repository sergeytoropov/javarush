package com.javarush.test.level20.lesson02.task04;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest extends Solution {
    private String filename =
            new File("").getAbsolutePath() + "/src/test/java/com/javarush/test/level20/lesson02/task04/test.txt";
    private String actualStaticString;

    ClassWithStatic actualCWS = new ClassWithStatic();

    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Before
    public void init() {
        actualStaticString = "Test class ClassWithStatic";
        actualCWS.i = 10;
        actualCWS.j = 20;
    }

    @Test
    public void load() throws Exception {
        ClassWithStatic cws = new ClassWithStatic();
        cws.load(new FileInputStream(filename));

        assertEquals(ClassWithStatic.staticString, actualStaticString);
        assertEquals(cws, actualCWS);
    }

    @Test
    public void save() throws Exception {
        ClassWithStatic cws = new ClassWithStatic();
        cws.load(new FileInputStream(filename));

        String tmpFileName = tmpFld.newFile().getAbsolutePath();
        cws.save(new FileOutputStream(tmpFileName));
        cws.load(new FileInputStream(tmpFileName));

        assertEquals(ClassWithStatic.staticString, actualStaticString);
        assertEquals(cws, actualCWS);
    }

}