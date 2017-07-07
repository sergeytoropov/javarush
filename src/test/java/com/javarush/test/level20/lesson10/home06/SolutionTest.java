package com.javarush.test.level20.lesson10.home06;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Test
    public void notSerializableException() throws IOException, ClassNotFoundException {
        String filename = tmpFld.newFile().getAbsolutePath();
        Solution.SubSolution subSolution = new Solution.SubSolution();

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(subSolution);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Solution.SubSolution s = (Solution.SubSolution) input.readObject();
        input.close();
    }

}