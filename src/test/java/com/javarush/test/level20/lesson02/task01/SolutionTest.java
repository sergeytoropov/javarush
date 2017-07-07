package com.javarush.test.level20.lesson02.task01;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.*;
import java.util.Locale;

import static org.junit.Assert.*;
//import com.javarush.test.level20.lesson02.task01.Solution.Human;

@RunWith(DataProviderRunner.class)
public class SolutionTest extends Solution {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    private boolean equals(InputStream expectedStream, InputStream actualStream) throws IOException {
        while (true) {
            if (expectedStream.available() > 0 && actualStream.available() > 0) {
                if (expectedStream.read() != actualStream.read()) {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void save(AnswersSet answers) throws IOException, Exception {
        Human human = new Human();
        human.load(new FileInputStream(answers.getFilename()));

        String filename = tmpFld.newFile().getAbsolutePath();
        human.save(new FileOutputStream(filename));

        assertTrue(equals(new FileInputStream(filename), new FileInputStream(answers.getFilename())));
    }

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void load(AnswersSet answers) throws Exception {
        // Загружаем только первый объект, а остальные пропускаем

        Human human = new Human();
        human.load(new FileInputStream(answers.getFilename()));

        assertEquals(human, answers.getHumans().get(0));
    }
}