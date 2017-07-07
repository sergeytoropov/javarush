package com.javarush.test.level20.lesson02.task03;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AnswersSet {
    final private static String path = "/src/test/java/com/javarush/test/level20/lesson02/task03/data/";
    private String filename;
    private Map<String, String> map = new HashMap<String, String>();

    private AnswersSet() {}

    private static AnswersSet test01() {
        AnswersSet answers = new AnswersSet();

        answers.filename = "test01.txt";
        answers.map.put("db.password", "123456");
        answers.map.put("db.sid", "cloud");
        answers.map.put("db.user", "admin");
        answers.map.put("db.hostname", "10.210.88.20");
        answers.map.put("location.path", "/home1/siriusmgr/database/loader");

        return answers;
    }

    public static AnswersSet[] create() {
        AnswersSet[] answers = new AnswersSet[1];
        answers[0] = AnswersSet.test01();
        return answers;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public String getFilename() {
        return new File("").getAbsolutePath() + path + filename;
    }
}
