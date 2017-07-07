package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        int id = 0;
        if (args.length == 1) {
            id = Integer.parseInt(args[0]);
        } else {
            System.out.println("Usage: Solution id");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(filename));
        String s;
        while ( (s = reader.readLine()) != null ) {
            String[] items = s.split(" ");
            if (id == Integer.parseInt(items[0])) {
                System.out.println(s);
            }
        }
        reader.close();
    }
}
