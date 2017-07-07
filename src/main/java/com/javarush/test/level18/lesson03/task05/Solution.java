package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = 0;
        }

        try {
            FileInputStream stream = new FileInputStream(filename);
            while (stream.available() > 0) {
                map[stream.read()] += 1;
            }
            stream.close();
        } catch (IOException e) {
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
