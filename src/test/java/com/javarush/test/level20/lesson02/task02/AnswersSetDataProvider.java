package com.javarush.test.level20.lesson02.task02;

import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.runners.model.FrameworkMethod;

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
