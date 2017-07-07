package com.javarush.test.level20.lesson02.task01;

import org.junit.runners.model.FrameworkMethod;
import com.tngtech.java.junit.dataprovider.DataProvider;
import java.io.IOException;

public class AnswersSetDataProvider {

    @DataProvider
    public static Object[][] load(FrameworkMethod fmwMethod) throws IOException {
        AnswersSet[] answers = AnswersSet.create();

        Object[][] objects = new Object[answers.length][1];
        for (int index = 0; index < answers.length; index++) {
            objects[index][0] = answers[index];
        }
        return objects;
    }

}
