package com.javarush.test.level20.lesson07.task03;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest extends Solution {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Test
    public void externalizable() throws IOException, ClassNotFoundException {
        String filename = tmpFld.newFile().getAbsolutePath();

        Person person = new Person("Sergey", "Toropov", 36);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(person);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Person p = (Person) input.readObject();

        assertEquals(p, person);
    }
}