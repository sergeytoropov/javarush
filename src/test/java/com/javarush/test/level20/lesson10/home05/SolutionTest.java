package com.javarush.test.level20.lesson10.home05;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Test
    public void person() throws IOException, ClassNotFoundException {
        String filename = tmpFld.newFile().getAbsolutePath();
        Solution.Person person = new Solution.Person("Sergey", "Toropov", "Vladivostok", Solution.Sex.MALE);

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(person);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Solution.Person p = (Solution.Person) input.readObject();
        input.close();

        assertEquals(p, person);
    }
}