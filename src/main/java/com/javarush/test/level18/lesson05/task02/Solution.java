package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            reader.close();

            int code = 44; // Символ ','
            int counter = 0;
            FileInputStream stream = new FileInputStream(filename);
            while (stream.available() > 0) {
                int ch = stream.read();
                if (ch == code) {
                    counter++;
                }
            }
            stream.close();

            System.out.println(counter);
        } catch (IOException e) {
        }
    }
}
