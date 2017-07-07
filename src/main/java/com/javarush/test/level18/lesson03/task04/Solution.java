package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
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

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            if (min > map[i] && map[i] > 0) {
                min = map[i];
            }
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}
