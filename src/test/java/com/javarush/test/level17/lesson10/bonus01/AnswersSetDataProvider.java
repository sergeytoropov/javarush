package com.javarush.test.level17.lesson10.bonus01;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class AnswersSetDataProvider {
    @DataProvider
    public static Object[][] load() {
        AnswersSet[] answers = AnswersSet.create();
        Object[][] objects = new Object[answers.length][1];

        int index = 0;
        for (AnswersSet answer: answers) {
            objects[index++][0] = answer;
        }

        return objects;
    }
}
