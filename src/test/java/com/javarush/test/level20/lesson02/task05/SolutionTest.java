package com.javarush.test.level20.lesson02.task05;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest extends Solution {
    private java.lang.String filename =
            new File("").getAbsolutePath() + "/src/test/java/com/javarush/test/level20/lesson02/task05/test.txt";

    private Object actualObject = new Object();

    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Before
    public void init() {
        actualObject.string1 = String.duplicate(7);
        actualObject.string2 = String.duplicate(9);
    }

    @Test
    public void equalsString() {
        String string1 = new String();
        String string2 = new String();
        //string1.print();
        //string2.print();

        assertNotEquals(string1, string2);
        assertEquals(string1, string1.duplicate());
        assertEquals(string2, String.duplicate(string2.getNumber()));
    }

    @Test
    public void equalsObject() {
        Object object = new Object();
        object.string1 = String.duplicate(7);
        object.string2 = String.duplicate(9);

        assertEquals(object, actualObject);
    }

    @Test
    public void load() throws FileNotFoundException, IOException, Exception {
        Object object = new Object();
        object.load(new FileInputStream(filename));

        assertEquals(object, actualObject);
    }

    @Test
    public void save() throws Exception {
        Object object = new Object();
        object.load(new FileInputStream(filename));

        java.lang.String tmpFileName = tmpFld.newFile().getAbsolutePath();
        object.save(new FileOutputStream(tmpFileName));
        object.load(new FileInputStream(tmpFileName));

        assertEquals(object, actualObject);
    }
}