package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        try {
            FileInputStream stream = new FileInputStream(filename);
            byte min = 0;
            while (stream.available() > 0) {
                byte b = (byte) stream.read();
                if (min < b) {
                    min = b;
                }
            }
            stream.close();
            System.out.print(min);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
