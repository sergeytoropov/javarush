package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        try {
            int[] map = new int[256];
            for (int i = 0; i < map.length; i++) {
                map[i] = 0;
            }

            FileInputStream stream = new FileInputStream(filename);
            while (stream.available() > 0) {
                map[stream.read()] += 1;
            }
            stream.close();

            int max = 0;
            for (int i = 0; i < map.length; i++) {
                if (max < map[i]) {
                    max = map[i];
                }
            }

            for (int i = 0; i < map.length; i++) {
                if (map[i] == max) {
                    System.out.print(i + " ");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
