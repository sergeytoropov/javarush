package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: Solution filename");
            return;
        }

        try {
            FileInputStream stream = new FileInputStream(args[0]);
            int blanks = 0;
            int symbols = 0;
            while (stream.available() > 0) {
                int b = stream.read();
                if (b == 0x20) {
                    blanks += 1;
                }
                symbols += 1;
            }
            stream.close();
            System.out.println(new Formatter().format("%.2f", (double) blanks/symbols*100));
            //System.out.println(String.format(Locale.ENGLISH, "%.2f", (double) blanks/symbols*100));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
