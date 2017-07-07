package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename = reader.readLine();
            reader.close();

            int counter = 0;
            reader = new BufferedReader(new FileReader(filename));
            String tmpS;
            while ( (tmpS = reader.readLine()) != null ) {
                char[] array = tmpS.toCharArray();
                String world = "";
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 'w') {
                        world = String.valueOf(array[i]);
                    } else {
                        world += String.valueOf(array[i]);
                        if ("world".equals(world)) {
                            counter += 1;
                        }
                    }
                }
            }
            reader.close();

            System.out.println(counter);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
