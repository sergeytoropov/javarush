package com.javarush.test.level20.lesson10.bonus02;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class SolutionTest extends Solution {

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void solve(AnswersSet answers) {
        assertEquals(Solution.getRectangleCount(answers.getA()), answers.getRectangleCount());
    }

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void restangles(AnswersSet answers) {
        Solve solve = new Solve(answers.getA());
        int iter = 0;
        while (solve.nextRectangle()) {
            //System.out.println("1");
            assertEquals(solve.getA(), answers.getRectangle(iter++));
        }
    }

}