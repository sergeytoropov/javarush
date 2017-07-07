package com.javarush.test.level20.lesson02.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AnswersSet {
    final private static String path = "/src/test/java/com/javarush/test/level20/lesson02/task02/data/";
    private String filename;
    private List<User> users = new ArrayList<User>();

    private AnswersSet() {}

    private static BufferedReader open(String filename) throws IOException {
        return new BufferedReader(new FileReader(new File("").getAbsolutePath() + path + filename));
    }

    private static void read(AnswersSet answers) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("").getAbsolutePath() + path + answers.filename));
        int quantity = Integer.parseInt(reader.readLine());

        for (int index = 0; index < quantity; index++) {
            User user = new User();
            user.setFirstName(reader.readLine());
            user.setLastName(reader.readLine());

            String strDate = reader.readLine();
            int year = Integer.parseInt(strDate.substring(0, 4));
            int month = Integer.parseInt(strDate.substring(4, 6));
            int day = Integer.parseInt(strDate.substring(6, 8));
            GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
            user.setBirthDate(calendar.getTime());

            String male = reader.readLine();
            boolean isMale = false;
            if ("yes".equals(male.toLowerCase())) {
                isMale = true;
            } else if ("no".equals(male.toLowerCase())) {
                isMale = false;
            } else {
                // Обработать исключительную ситуацию
            }
            user.setMale(isMale);

            String strCountry = reader.readLine();
            User.Country country = User.Country.OTHER;
            if ("Ukraine".equals(strCountry)) {
                country = User.Country.UKRAINE;
            } else if ("Russia".equals(strCountry)) {
                country = User.Country.RUSSIA;
            } else if ("Other".equals(strCountry)) {
                country = User.Country.OTHER;
            } else {
                // Обработать исключительную ситуацию
            }
            user.setCountry(country);

            answers.users.add(user);
        }
        reader.close();
    }

    private static AnswersSet test01() throws IOException {
        AnswersSet answers = new AnswersSet();

        answers.filename = "test01.txt";
        read(answers);

        return answers;
    }

    private static AnswersSet test02() throws IOException {
        AnswersSet answers = new AnswersSet();

        answers.filename = "test02.txt";
        read(answers);

        return answers;
    }

    public static AnswersSet[] create() throws IOException {
        AnswersSet[] answers = new AnswersSet[2];
        answers[0] = AnswersSet.test01();
        answers[1] = AnswersSet.test02();
        return answers;
    }

    public String getFilename() {
        return new File("").getAbsolutePath() + path + filename;
    }

    public List<User> getUsers() {
        return users;
    }
}
