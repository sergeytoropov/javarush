package com.javarush.test.level20.lesson02.task03;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class AnswersSetDataProvider {

    @DataProvider
    public static Object[][] load() {
        AnswersSet[] answers = AnswersSet.create();
        Object[][] objects = new Object[answers.length][1];

        int index = 0;
        for (AnswersSet aSet: answers) {
            objects[index++][0] = aSet;
        }
        return objects;
    }
}
