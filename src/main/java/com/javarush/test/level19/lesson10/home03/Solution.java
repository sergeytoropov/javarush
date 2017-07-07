package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void usage() {
        System.out.println("Usage: Solution filename");
        System.exit(0);
    }

    public static void init(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<String> items = new ArrayList<String>();

        String tmpS;
        while ( (tmpS = reader.readLine()) != null ) {
            items.clear();
            Scanner scanner = new Scanner(tmpS);
            while (scanner.hasNext()) {
                items.add(scanner.next());
            }
            scanner.close();

            addPerson(items);
        }
        reader.close();
    }

    public static void addPerson(ArrayList<String> items) {
        int year  = Integer.parseInt(items.get(items.size() - 1));
        int month = Integer.parseInt(items.get(items.size() - 2));
        int day   = Integer.parseInt(items.get(items.size() - 3));

        String name = "";
        for (int idx = 0; idx < items.size() - 3; idx++) {
            name += items.get(idx) + " ";
        }
        name = name.trim();

        PEOPLE.add(new Person(name, new GregorianCalendar(year, month - 1, day).getTime()));
    }

    public static void print() {
        for (Person p: PEOPLE) {
            System.out.println(p.getName() + " " + p.getBirthday());
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            usage();
        }
        String filename = args[0];

        init(filename);
        //print();
    }

}
