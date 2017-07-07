package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        try {
            FileInputStream stream = new FileInputStream(filename);
            int min = Integer.MAX_VALUE;

            while (stream.available() > 0) {
                int b = stream.read();
                if (min > b) {
                    min = b;
                }
            }
            System.out.println(min);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
