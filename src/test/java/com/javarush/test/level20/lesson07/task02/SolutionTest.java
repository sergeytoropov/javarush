package com.javarush.test.level20.lesson07.task02;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest extends Solution {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Test
    public void outputToConsole() {
        PrintStream out = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        OutputToConsole console = new OutputToConsole(22);
        console.outputToConsole(22);
        System.setOut(out);

        assertEquals(output.toString(), greeting);
    }

    @Test
    public void Externalizable() throws IOException, ClassNotFoundException {
        String filename = tmpFld.newFile().getAbsolutePath();
        OutputToConsole actualConsole = new OutputToConsole(22);

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(actualConsole);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Object o = input.readObject();
        OutputToConsole console = (OutputToConsole) o;

        assertEquals(console, actualConsole);
    }
}