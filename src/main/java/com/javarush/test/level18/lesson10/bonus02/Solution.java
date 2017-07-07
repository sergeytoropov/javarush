package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-с  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

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

    private static int maxId(ArrayList<Integer> ids) {
        int max = 0;
        for (Integer id: ids) {
            if (max < id) {
                max = id;
            }
        }
        max += 1;
        return max;
    }

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


    public static void main(String[] args) throws Exception {


        if (args.length == 4) {
            if ("-c".equals(args[0])) {
                productName = args[1];
                price = Double.parseDouble(args[2]);
                quantity = Integer.parseInt(args[3]);
            } else {
                usage();
            }
        } else {
            usage();
        }

        ArrayList<Integer> ids = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(filename));
            String s;
            while ( (s = reader.readLine()) != null ) {
                ids.add(Integer.parseInt(s.substring(0, 8).trim()));
            }
            reader.close();

            id = maxId(ids);

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(createRecord());
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void usage() {
        System.out.println("Usage: Solution -c productName price quantity");
        System.exit(0);
    }
}
