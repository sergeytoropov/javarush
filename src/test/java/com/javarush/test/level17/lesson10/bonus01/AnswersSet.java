package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class AnswersSet {
    private String[] args;
    private Solution.Operation oper;
    private int id;
    private String name;
    private Sex sex;
    private Date bd;
    private Person person;
    private String line;

    private AnswersSet() {}

    private static AnswersSet test01() {
        AnswersSet answers = new AnswersSet();
        answers.args = new String[] {"-c", "Миронов", "м", "15/04/1990"};
        answers.oper = Solution.Operation.CREATE;
        answers.id = 0;
        answers.name = "Миронов";
        answers.sex = Sex.MALE;
        answers.bd = new GregorianCalendar(1990, Calendar.APRIL, 15).getTime();
        answers.line = "2";

        return answers;
    }

    private static AnswersSet test02() {
        AnswersSet answers = new AnswersSet();
        answers.args = new String[] {"-u", "2", "Торопова", "ж", "10/10/1978"};
        answers.oper = Solution.Operation.UPDDATE;
        answers.id = 2;
        answers.name = "Торопова";
        answers.sex = Sex.FEMALE;
        answers.bd = new GregorianCalendar(1978, Calendar.OCTOBER, 10).getTime();
        answers.person = Person.createFemale(answers.name, answers.bd);
        answers.line = null;

        return answers;
    }

    private static AnswersSet test03() {
        AnswersSet answers = new AnswersSet();
        answers.args = new String[] {"-d", "2"};
        answers.oper = Solution.Operation.DELETE;
        answers.id = 2;
        answers.name = null;
        answers.sex = null;
        answers.bd = null;
        answers.line = null;

        return answers;
    }

    private static AnswersSet test04() {
        AnswersSet answers = new AnswersSet();
        answers.args = new String[] {"-i", "0"};
        answers.oper = Solution.Operation.INFO;
        answers.id = 0;
        answers.name = null;
        answers.sex = null;
        answers.bd = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        answers.line = "Иванов Иван м " + sdf.format(new Date());

        return answers;
    }

    public static AnswersSet[] create() {
        AnswersSet[] answers = new AnswersSet[4];

        answers[0] = test01();
        answers[1] = test02();
        answers[2] = test03();
        answers[3] = test04();

        return answers;
    }

    @Override
    public String toString() {
        return args[0];
    }

    public String[] getArgs() {
        return args;
    }

    public Solution.Operation getOper() {
        return oper;
    }

    public String getLine() {
        return line;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Date getBd() {
        return bd;
    }

    public Person getPerson() {
        return person;
    }
}
