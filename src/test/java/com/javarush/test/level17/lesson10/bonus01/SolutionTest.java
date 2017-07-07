package com.javarush.test.level17.lesson10.bonus01;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class SolutionTest extends Solution {

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void init(AnswersSet answers) {
        Init init = new Init(answers.getArgs());
        assertEquals(init.getOperation(), answers.getOper());
        assertEquals(init.getId(), answers.getId());
        assertEquals(init.getName(), answers.getName());
        assertEquals(init.getSex(), answers.getSex());
        assertEquals(init.getBd(), answers.getBd());
    }

    private void create(AnswersSet answers) throws IOException {
        PrintStream out = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Solution.main(answers.getArgs());
        System.setOut(out);

        BufferedReader reader = new BufferedReader(new StringReader(output.toString()));
        assertEquals(reader.readLine(), answers.getLine());
    }

    private void update(AnswersSet answers) {
        Solution.main(answers.getArgs());
        assertEquals(Solution.allPeople.get(answers.getId()), answers.getPerson());
    }

    private void delete(AnswersSet answers) {
        Solution.main(answers.getArgs());
        assertTrue(Solution.allPeople.get(answers.getId()).isDeleted());
    }

    private void info(AnswersSet answers) throws IOException {
        PrintStream out = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Solution.main(answers.getArgs());
        System.setOut(out);

        BufferedReader reader = new BufferedReader(new StringReader(output.toString()));
        assertEquals(reader.readLine(), answers.getLine());

    }

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void operation(AnswersSet answers) throws IOException {
        switch (answers.getOper()) {
            case CREATE:
                create(answers);
                break;

            case UPDDATE:
                update(answers);
                break;

            case DELETE:
                delete(answers);
                break;

            case INFO:
                info(answers);
                break;
        }
    }
}