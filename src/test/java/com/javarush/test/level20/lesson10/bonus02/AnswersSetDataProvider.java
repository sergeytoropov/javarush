package com.javarush.test.level20.lesson10.bonus02;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class AnswersSetDataProvider {
    @DataProvider
    public static Object[][] load() {
        AnswersSet[] aSets = AnswersSet.create();
        Object[][] objects = new Object[aSets.length][1];
        
        int index = 0;
        for (AnswersSet aSet: aSets) {
            objects[index++][0] = aSet;
        }

        return objects;
    }
}
