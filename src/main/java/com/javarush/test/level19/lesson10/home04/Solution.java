package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    private static boolean search(String s) {
        Scanner scanner = new Scanner(s);

        int counter = 0;
        while (scanner.hasNext()) {
            String item = scanner.next();
            for (String word: words) {
                if (word.equals(item)) {
                    counter += 1;
                }
            }
        }

        if (counter == 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(filename));
            String tmpS;
            while ( (tmpS = reader.readLine()) != null ) {
                if (search(tmpS)) {
                    System.out.println(tmpS);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
