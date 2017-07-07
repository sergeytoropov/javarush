package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

public class Solution {
    static int id = 0;
    static String productName = "default";
    static double price = 0.0;
    static int quantity = 0;
    static ArrayList<String> items = new ArrayList<String>();

    private static String createRecord() {
        Formatter fId = new Formatter();
        fId.format("%-8d", id);
        String id = String.format("%8.8s", fId.toString());

        Formatter fPrice = new Formatter();
        fPrice.format(Locale.ENGLISH, "%-8.2f", price);
        String price = String.format("%8.8s", fPrice.toString());

        Formatter fQuantity = new Formatter();
        fQuantity.format("%-4d", quantity);
        String quantity = String.format("%4.4s", fQuantity.toString());

        //return String.format(Locale.ENGLISH, "%-8d%-30.30s%-8.2f%-4d", id, name, price, quantity);
        return String.format("%s%-30.30s%s%s", id, productName, price, quantity);
    }

    private static void update(ArrayList<String> records) {
        items.clear();
        for (String rec: records) {
            int curId = Integer.parseInt(rec.substring(0, 8).trim());
            if (curId == id) {
                items.add(createRecord());
            } else {
                items.add(rec);
            }
        }
    }

    private static void delete(ArrayList<String> records) {
        items.clear();
        for (String rec: records) {
            int curId = Integer.parseInt(rec.substring(0, 8).trim());
            if (curId != id) {
                items.add(rec);
            }
        }
    }

    private static void save(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String item: items) {
            writer.write(item);
            writer.newLine();
        }
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 5) {
            if ("-u".equals(args[0])) {
                id = Integer.parseInt(args[1]);
                productName = args[2];
                price = Double.parseDouble(args[3]);
                quantity = Integer.parseInt(args[4]);
            } else {
                usage();
            }
        } else if (args.length == 2) {
            if ("-d".equals(args[0])) {
                id = Integer.parseInt(args[1]);
            } else {
                usage();
            }
        } else {
            usage();
        }

        ArrayList<String> records = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(filename));
            String s;
            while ( (s = reader.readLine()) != null ) {
                records.add(s);
            }
            reader.close();

            if ("-u".equals(args[0])) {
                update(records);
            } else if ("-d".equals(args[0])) {
                delete(records);
            }
            save(filename);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void usage() {
        System.out.println("Usage: Solution -u id productName price quantity | -d id");
        System.exit(0);
    }
}