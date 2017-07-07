package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

public class AnswersSet {
    private int[][] crossword;
    private List<Solution.Word> words = new ArrayList<Solution.Word>();
    private String[] keyWords;

    private AnswersSet() {}

    private static AnswersSet test01() {
        AnswersSet answers = new AnswersSet();

        answers.crossword = new int[][] {
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        answers.keyWords = new String[] {"same", "home"};

        Solution.Word word;

        word = new Solution.Word("same");
        word.setStartPoint(1, 1);
        word.setEndPoint(4, 1);
        answers.words.add(word);

        word = new Solution.Word("home");
        word.setStartPoint(5, 3);
        word.setEndPoint(2, 0);
        answers.words.add(word);

        return answers;
    }

    public static AnswersSet test02() {
        AnswersSet answers = new AnswersSet();

        answers.crossword = new int[][] {
                {'e', 'f', 'f', 'e', 'f', 'f', 'e'},
                {'f', 'm', 'f', 'm', 'f', 'm', 'f'},
                {'f', 'f', 'o', 'o', 'o', 'f', 'f'},
                {'e', 'm', 'o', 'h', 'o', 'm', 'e'},
                {'f', 'f', 'o', 'o', 'o', 'f', 'f'},
                {'f', 'm', 'f', 'm', 'f', 'm', 'f'},
                {'e', 'f', 'f', 'e', 'f', 'f', 'e'}
        };

        answers.keyWords = new String[] {"home"};

        Solution.Word word;

        // Вправо
        word = new Solution.Word("home");
        word.setStartPoint(3, 3);
        word.setEndPoint(6, 3);
        answers.words.add(word);

        // Влево
        word = new Solution.Word("home");
        word.setStartPoint(3, 3);
        word.setEndPoint(0, 3);
        answers.words.add(word);

        // Вверх
        word = new Solution.Word("home");
        word.setStartPoint(3, 3);
        word.setEndPoint(3, 0);
        answers.words.add(word);

        // Вниз
        word = new Solution.Word("home");
        word.setStartPoint(3, 3);
        word.setEndPoint(3, 6);
        answers.words.add(word);

        // ВврехВправо
        word = new Solution.Word("home");
        word.setStartPoint(3, 3);
        word.setEndPoint(6, 0);
        answers.words.add(word);

        // ВверВлево
        word = new Solution.Word("home");
        word.setStartPoint(3, 3);
        word.setEndPoint(0, 0);
        answers.words.add(word);

        // ВнизВправо
        word = new Solution.Word("home");
        word.setStartPoint(3, 3);
        word.setEndPoint(6, 6);
        answers.words.add(word);

        // ВнизВлево
        word = new Solution.Word("home");
        word.setStartPoint(3, 3);
        word.setEndPoint(0, 6);
        answers.words.add(word);

        return answers;
    }

    public static AnswersSet[] create() {
        AnswersSet[] answers = new AnswersSet[2];

        answers[0] = test01();
        answers[1] = test02();

        return answers;
    }

    @Override
    public String toString() {
        return words.toString();
    }

    public int[][] getCrossword() {
        return crossword;
    }

    public List<Solution.Word> getWords() {
        return words;
    }

    public String[] getKeyWords() {
        return keyWords;
    }
}
