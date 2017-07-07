package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static Init init;

    private static void create() {
        if (init.getSex() == Sex.MALE) {
            allPeople.add(Person.createMale(init.getName(), init.getBd()));
            System.out.println(allPeople.size() - 1);
        } else if (init.getSex() == Sex.FEMALE) {
            allPeople.add(Person.createFemale(init.getName(), init.getBd()));
            System.out.println(allPeople.size() - 1);
        }
    }

    private static void update() {
        Person person = allPeople.get(init.getId());
        person.setName(init.getName());
        person.setSex(init.getSex());
        person.setBirthDay(init.getBd());
    }

    private static void delete() {
        allPeople.get(init.getId()).setDeleted(true);
    }

    private static void info() {
        Person person = allPeople.get(init.getId());
        if (!person.isDeleted()) {
            String charSex = "";
            if (person.getSex() == Sex.MALE) {
                charSex = "м";
            } else if (person.getSex() == Sex.FEMALE) {
                charSex = "ж";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(person.getName() + " " + charSex + " " + sdf.format(person.getBirthDay()));
        }
    }

    public static void main(String[] args) {
        //start here - начни тут
        init = new Init(args);

        switch (init.getOperation()) {
            case CREATE:
                create();
                break;

            case UPDDATE:
                update();
                break;

            case DELETE:
                delete();
                break;

            case INFO:
                info();
                break;
        }
    }

    public static enum Operation {CREATE, UPDDATE, DELETE, INFO};

    public static class Init {
        private String operation;
        private String id;
        private String name;
        private String sex;
        private String bd;

        public Init(String[] args) {
            operation = null;
            id = null;
            name = null;
            sex = null;
            bd = null;

            if (args.length > 0) {
                operation = args[0];

                if (args.length == 4) {
                    name = args[1];
                    sex = args[2];
                    bd = args[3];
                } else if (args.length == 5) {
                    id = args[1];
                    name = args[2];
                    sex = args[3];
                    bd = args[4];
                } else if (args.length == 2) {
                    id = args[1];
                } else {
                    // throw IllegalStateException
                }
            }
        }

        public Operation getOperation() {
            Operation oper = null;

            if ("-c".equals(operation)) {
                oper = Operation.CREATE;
            } else if ("-u".equals(operation)) {
                oper = Operation.UPDDATE;
            } else if ("-d".equals(operation)) {
                oper = Operation.DELETE;
            } else if ("-i".equals(operation)) {
                oper = Operation.INFO;
            }

            return oper;
        }

        public int getId() {
            if (id == null) {
                return 0;
            }

            return Integer.parseInt(id);
        }

        public String getName() {
            return name;
        }

        public Sex getSex() {
            Sex sex = null;

            if ("м".equals(this.sex)) {
                sex = Sex.MALE;
            } else if ("ж".equals(this.sex)) {
                sex = Sex.FEMALE;
            }

            return sex;
        }

        public Date getBd() {
            if (bd == null) {
                return null;
            }

            int day = Integer.parseInt(bd.substring(0, 2));
            int month = Integer.parseInt(bd.substring(3, 5));
            int year = Integer.parseInt(bd.substring(6, 10));
            return new GregorianCalendar(year, month - 1, day).getTime();
        }
    }
}
