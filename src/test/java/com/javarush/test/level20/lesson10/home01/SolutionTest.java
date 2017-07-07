package com.javarush.test.level20.lesson10.home01;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Rule
    transient public TemporaryFolder tmpFld = new TemporaryFolder();

    private void print(Solution s) {
        System.out.println("A="+s.a);
        System.out.println("B="+s.b);
        System.out.println("C="+s.c);
    }

    @Test
    public void serializable() throws IOException, ClassNotFoundException {
        String filename = tmpFld.newFile().getAbsolutePath();

        Solution s = new Solution();

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(s);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Solution sss = (Solution) input.readObject();
        input.close();

        print(s);
        System.out.println("****");
        print(sss);
    }
}