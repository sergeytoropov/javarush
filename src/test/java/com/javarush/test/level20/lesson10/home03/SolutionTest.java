package com.javarush.test.level20.lesson10.home03;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Rule
    transient public TemporaryFolder tmpFld = new TemporaryFolder();


    @Test
    public void serializable() throws IOException, ClassNotFoundException {
        String filename = tmpFld.newFile().getAbsolutePath();

        Solution solution = new Solution();
        Solution.B b = solution.new B("Sergey");
        System.out.println(b);


        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(b);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Solution.B bbb = (Solution.B) input.readObject();
        input.close();

        System.out.println("***");
        System.out.println(bbb);
    }
}