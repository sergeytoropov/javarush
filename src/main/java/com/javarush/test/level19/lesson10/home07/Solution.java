package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: filename1, filename2");
            System.exit(0);
        }

        String filename1 = args[0];
        String filename2 = args[1];
        Solution.algorithm(filename1, filename2);
    }

    public static void algorithm(String filename1, String filename2) {
        ArrayList<String> list = new ArrayList<String>();
        String s;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename1));
            while ( (s = reader.readLine()) != null ) {
                String[] words = s.split(" ");
                for (String word: words) {
                    if (word.length() > 6) {
                        list.add(word);
                    }
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename2));
            boolean isStarted = true;
            for (String word: list) {
                if (!isStarted) {
                    writer.write(",");
                } else {
                    isStarted = false;
                }
                writer.write(word);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
