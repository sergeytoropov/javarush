package com.javarush.test.level20.lesson10.home02;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Test
    public void getOriginalObject() throws IOException, ClassNotFoundException {
        String filenameA = tmpFld.newFile().getAbsolutePath();
        String filenameB = tmpFld.newFile().getAbsolutePath();

        Solution solution = new Solution();
        Solution.A a = solution.new A();
        Solution.B b = solution.new B();

        ObjectOutputStream outputA = new ObjectOutputStream(new FileOutputStream(filenameA));
        outputA.writeObject(a);
        outputA.close();

        ObjectOutputStream outputB = new ObjectOutputStream(new FileOutputStream(filenameB));
        outputB.writeObject(b);
        outputB.close();

        ObjectInputStream inputA = new ObjectInputStream(new FileInputStream(filenameA));
        assertTrue(inputA.readObject() instanceof Solution.A);
        inputA.close();

        ObjectInputStream inputB = new ObjectInputStream(new FileInputStream(filenameB));
        assertTrue(inputB.readObject() instanceof Solution.B);
        inputB.close();
    }
}