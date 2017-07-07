package com.javarush.test.level20.lesson10.bonus03;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class SolutionTest extends Solution {
    private AnswersSet answers = AnswersSet.test02();
    private Algorithm algorithm;
    private int startX = 3;
    private int startY = 3;

    @Test
    @UseDataProvider(value = "load", location = AnswersSetDataProvider.class)
    public void algoritm(AnswersSet answers) {
        assertEquals(Solution.detectAllWords(answers.getCrossword(), answers.getKeyWords()), answers.getWords());
    }

    @Before
    public void init() {
        algorithm = new Algorithm(answers.getCrossword(), answers.getKeyWords());
    }

    @Test
    public void right() {
        Word word = algorithm.right(startX, startY, answers.getKeyWords()[0], 0);
        word.setStartPoint(startX, startY);
        word.reverse();
        assertEquals(word, answers.getWords().get(0));
    }

    @Test
    public void left() {
        Word word = algorithm.left(startX, startY, answers.getKeyWords()[0], 0);
        word.setStartPoint(startX, startY);
        word.reverse();
        assertEquals(word, answers.getWords().get(1));
    }

    @Test
    public void top() {
        Word word = algorithm.top(startY, startY, answers.getKeyWords()[0], 0);
        word.setStartPoint(startX, startY);
        word.reverse();
        assertEquals(word, answers.getWords().get(2));
    }

    @Test
    public void bottom() {
        Word word = algorithm.bottom(startY, startY, answers.getKeyWords()[0], 0);
        word.setStartPoint(startX, startY);
        word.reverse();
        assertEquals(word, answers.getWords().get(3));
    }

    @Test
    public void topRight() {
        Word word = algorithm.topRight(startY, startY, answers.getKeyWords()[0], 0);
        word.setStartPoint(startX, startY);
        word.reverse();
        assertEquals(word, answers.getWords().get(4));

    }

    @Test
    public void topLeft() {
        Word word = algorithm.topLeft(startY, startY, answers.getKeyWords()[0], 0);
        word.setStartPoint(startX, startY);
        word.reverse();
        assertEquals(word, answers.getWords().get(5));
    }

    @Test
    public void bottomRight() {
        Word word = algorithm.bottomRight(startY, startY, answers.getKeyWords()[0], 0);
        word.setStartPoint(startX, startY);
        word.reverse();
        assertEquals(word, answers.getWords().get(6));
    }

    @Test
    public void bottomLeft() {
        Word word = algorithm.bottomLeft(startY, startY, answers.getKeyWords()[0], 0);
        word.setStartPoint(startX, startY);
        word.reverse();
        assertEquals(word, answers.getWords().get(7));
    }
}