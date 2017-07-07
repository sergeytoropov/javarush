package com.javarush.test.level20.lesson02.task03;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.*;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class SolutionTest {
    @Rule
    public TemporaryFolder tmpFld = new TemporaryFolder();

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void fillInPropertiesMap(AnswersSet answers) throws FileNotFoundException, IOException {
        InputStream in = System.in;
        System.setIn(new ByteArrayInputStream(answers.getFilename().getBytes()));

        Solution s = new Solution();

        s.fillInPropertiesMap();
        assertEquals(Solution.properties, answers.getMap());

        System.setIn(in);
    }

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void load(AnswersSet answers) throws FileNotFoundException, IOException, Exception {
        Solution s = new Solution();
        s.load(new FileInputStream(answers.getFilename()));
        assertEquals(Solution.properties, answers.getMap());
    }

    private void cat(String filename) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        System.out.println("Begin");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("End");
        reader.close();
    }

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void save(AnswersSet answers) throws FileNotFoundException, IOException, Exception {
        String filename = tmpFld.newFile().getAbsolutePath();

        InputStream in = System.in;
        System.setIn(new ByteArrayInputStream(answers.getFilename().getBytes()));

        Solution s = new Solution();
        s.fillInPropertiesMap();
        s.save(new FileOutputStream(filename));

        cat(filename);

        s.load(new FileInputStream(filename));
        assertEquals(Solution.properties, answers.getMap());
    }
}