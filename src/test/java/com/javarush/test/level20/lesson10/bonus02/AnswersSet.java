package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;
import java.util.List;

public class AnswersSet {
    private byte[][] a;
    private int rectangleCount;

    private List<byte[][]> rectangles = new ArrayList<byte[][]>();
    private AnswersSet() {}

    private static AnswersSet test01() {
        AnswersSet answers = new AnswersSet();

        answers.a = new byte[][] {
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 0, 1}
        };
        answers.rectangleCount = 2;

        byte[][] iter;

        iter = new byte[][] {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        answers.rectangles.add(iter);

        return answers;
    }

    public byte[][] getRectangle(int iter) {
        return rectangles.get(iter);
    }

    private static AnswersSet test02() {
        AnswersSet answers = new AnswersSet();

        answers.a = new byte[][] {
                {0, 1, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1}
        };
        answers.rectangleCount = 9;

        byte[][] iter;

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 1, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1}
        };
        answers.rectangles.add(iter);

        iter = new byte[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        answers.rectangles.add(iter);

        return answers;
    }

    public static AnswersSet[] create() {
        AnswersSet[] answers = new AnswersSet[2];

        answers[0] = test01();
        answers[1] = test02();

        return answers;
    }

    public byte[][] getA() {
        return a;
    }

    public int getRectangleCount() {
        return rectangleCount;
    }
}
