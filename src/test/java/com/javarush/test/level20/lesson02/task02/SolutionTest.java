package com.javarush.test.level20.lesson02.task02;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
//import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class SolutionTest extends Solution {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void load(AnswersSet answers) throws IOException, Exception {
        JavaRush javarush = new JavaRush();
        javarush.load(new FileInputStream(answers.getFilename()));

        assertArrayEquals(javarush.users.toArray(), answers.getUsers().toArray());
    }

    private boolean equalsFile(InputStream expected, InputStream actual) throws IOException {
        boolean isEquals = true;
        while (true) {
            if (expected.available() > 0 && actual.available() > 0) {
                int expectedChar = expected.read();
                int actualChar = actual.read();

                if (expectedChar != actualChar) {

//                    System.out.println("[" + (char) expectedChar + "] - [" + (char) actualChar + "]");
                    isEquals = false;
                    break;
                }
                //System.out.println("[" + (char) expectedChar + "] - [" + (char) actualChar + "]");
            } else {
                break;
            }
        }
        if (expected.available() > 0 || actual.available() > 0) {
            //isEquals = false;
            //System.out.println("Разные длины");
        }
        return isEquals;
    }

    private void cat(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[" + line + "]");
            }
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void save(AnswersSet answers) throws IOException, Exception {
        JavaRush javarush = new JavaRush();
        javarush.load(new FileInputStream(answers.getFilename()));

        String filename = tmpFld.newFile().getAbsolutePath();
        javarush.save(new FileOutputStream(filename));

        cat(filename);
        assertTrue(equalsFile(new FileInputStream(filename), new FileInputStream(answers.getFilename())));
    }

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void loadSaveLoad(AnswersSet answers) throws IOException, Exception {
        JavaRush javarush = new JavaRush();
        javarush.load(new FileInputStream(answers.getFilename()));

        String filename = tmpFld.newFile().getAbsolutePath();
        javarush.save(new FileOutputStream(filename));

        JavaRush javarushNew = new JavaRush();
        javarushNew.load(new FileInputStream(filename));

        assertArrayEquals(javarushNew.users.toArray(), answers.getUsers().toArray());
    }

    @Test
    public void equals() {
        JavaRush jr1 = new JavaRush();
        JavaRush jr2 = new JavaRush();

        User user1 = new User();
        user1.setFirstName("Sergey");
        user1.setLastName("Toropov");
        user1.setBirthDate(new Date(1978, 10, 22));
        user1.setMale(true);
        user1.setCountry(User.Country.RUSSIA);

        jr1.users.add(user1);

        User user2 = new User();
        user2.setFirstName("Sergey");
        user2.setLastName("Toropov");
        user2.setBirthDate(new Date(1978, 10, 22));
        user2.setMale(true);
        user2.setCountry(User.Country.RUSSIA);

        jr2.users.add(user2);

        assertEquals(jr1, jr2);

        user2.setCountry(User.Country.OTHER);

        assertNotEquals(jr1, jr2);
    }

    @Test
    //@Ignore
    public void Date() {
        /*
        String dt = "19781001";
        System.out.println(dt.substring(0, 4));
        System.out.println(dt.substring(4, 6));
        System.out.println(dt.substring(6, 8));

        Date date = new Date(1978, 10, 22);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println("Date = " + sdf.format(date));
        GregorianCalendar calendar = new GregorianCalendar(1978, 11, 22);
        Date dt1 = calendar.getTime();
        System.out.println("Date2 = " + sdf.format(dt1));
        */
    }
}