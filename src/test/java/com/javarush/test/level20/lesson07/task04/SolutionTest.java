package com.javarush.test.level20.lesson07.task04;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Test
    public void test()throws IOException, ClassNotFoundException {
        String filename = tmpFld.newFile().getAbsolutePath();

        Solution solution = new Solution(22);

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(solution);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Solution s = (Solution) input.readObject();
        input.close();

        System.out.println(s);
        System.out.println(solution);

        assertEquals(s, solution);
    }

}