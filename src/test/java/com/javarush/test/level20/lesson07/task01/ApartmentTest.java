package com.javarush.test.level20.lesson07.task01;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class ApartmentTest extends Solution {
    private String path = "/src/test/java/com/javarush/test/level20/lesson07/task01/data/";

    @Test
    public void test() throws FileNotFoundException, IOException, ClassNotFoundException {
        Apartment apartment = new Apartment("abcd", 2015);
        Apartment apartment2 = new Apartment("abcd", 2015);

        String filename = new File("").getAbsolutePath() + path + "test01.dat";
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(apartment);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Object obj = input.readObject();
        Apartment ap = (Apartment) obj;
        assertEquals(apartment, ap);
    }
}