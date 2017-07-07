package com.javarush.test.level20.lesson02.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnswersSet extends Solution {
    final private static String path = "/src/test/java/com/javarush/test/level20/lesson02/task01/data/";
    private String filename;
    private ArrayList<Human> humans = new ArrayList<Human>();

    private AnswersSet() {}

    private static BufferedReader open(String filename) throws IOException {
        return new BufferedReader(new FileReader(new File("").getAbsolutePath() + path + filename));
    }

    private static AnswersSet test01() throws IOException {
        AnswersSet answers = new AnswersSet();

        answers.filename = "test01.txt";
        BufferedReader reader = open(answers.filename);

        answers.humans.add(new Human(reader.readLine()));

        reader.close();

        return answers;
    }

    private static AnswersSet test02() throws IOException {
        AnswersSet answers = new AnswersSet();

        answers.filename = "test02.txt";
        BufferedReader reader = open(answers.filename);

        Human human = new Human(reader.readLine());
        int length = Integer.parseInt(reader.readLine());

        Asset a1 = new Asset(reader.readLine());
        a1.setPrice(Double.parseDouble(reader.readLine()));
        human.assets.add(a1);

        Asset a2 = new Asset(reader.readLine());
        a2.setPrice(Double.parseDouble(reader.readLine()));
        human.assets.add(a2);

        Asset a3 = new Asset(reader.readLine());
        a3.setPrice(Double.parseDouble(reader.readLine()));
        human.assets.add(a3);

        answers.humans.add(human);

        reader.close();

        return answers;
    }

    private static AnswersSet test03() throws IOException {
        AnswersSet answers = new AnswersSet();

        answers.filename = "test03.txt";
        BufferedReader reader = open(answers.filename);

        Human human1 = new Human(reader.readLine());
        int length1 = Integer.parseInt(reader.readLine());

        Asset a1_1 = new Asset(reader.readLine());
        a1_1.setPrice(Double.parseDouble(reader.readLine()));
        human1.assets.add(a1_1);

        Human human2 = new Human(reader.readLine());
        int length2 = Integer.parseInt(reader.readLine());

        Human human3 = new Human(reader.readLine());
        int length3 = Integer.parseInt(reader.readLine());

        Asset a3_1 = new Asset(reader.readLine());
        a3_1.setPrice(Double.parseDouble(reader.readLine()));
        human3.assets.add(a3_1);

        Asset a3_2 = new Asset(reader.readLine());
        a3_2.setPrice(Double.parseDouble(reader.readLine()));
        human3.assets.add(a3_2);

        Human human4 = new Human(reader.readLine());
        int length4 = Integer.parseInt(reader.readLine());

        Asset a4_1 = new Asset(reader.readLine());
        a4_1.setPrice(Double.parseDouble(reader.readLine()));
        human4.assets.add(a4_1);

        answers.humans.add(human1);
        answers.humans.add(human2);
        answers.humans.add(human3);
        answers.humans.add(human4);

        reader.close();

        return answers;
    }

    public static AnswersSet[] create() throws IOException {
        AnswersSet[] answers = new AnswersSet[3];
        answers[0] = AnswersSet.test01();
        answers[1] = AnswersSet.test02();
        answers[2] = AnswersSet.test03();
        return answers;
    }

    public String getFilename() {
        return new File("").getAbsolutePath() + path + filename;
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }
}
